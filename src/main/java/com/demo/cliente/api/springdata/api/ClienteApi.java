package com.demo.cliente.api.springdata.api;

import com.demo.cliente.api.springdata.dto.ClienteDto;
import com.demo.cliente.api.springdata.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/cliente")
@Slf4j
public class ClienteApi {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    public List<ClienteDto> buscarClientes() {
        log.info("Busqueda todos Cientes");
        return clienteService.obtenerClientes();
    }

    @GetMapping("/parameter")
    public ClienteDto buscarCliente(@RequestParam String identificacion){
        log.info("Busqueda de Ciente");
        return  clienteService.obtenerClientePorIdentificacion(identificacion);
    }

    @PostMapping
    public void crearCliente(@RequestBody ClienteDto clienteDto){
        log.info("Cliente a Agregar: {}", clienteDto);
        clienteService.insertarCliente(clienteDto);

    }

    @PutMapping
    public void actualizarCliente(@RequestBody ClienteDto clienteDto){
        log.info("Cliente actualizar: {}", clienteDto);
        clienteService.actualizarCliente(clienteDto);

    }
    @PutMapping(value="/desactivarCliente")
    public void desactivarCliente(@RequestBody ClienteDto clienteDto){
        log.info("Cliente actualizar: {}", clienteDto);
        clienteService.desactivarClientesActivos(clienteDto.getId());

    }

}
