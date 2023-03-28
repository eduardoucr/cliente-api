package com.demo.cliente.api.springdata.service;

import com.demo.cliente.api.springdata.dto.ClienteDto;
import com.demo.cliente.api.springdata.model.Cliente;
import com.demo.cliente.api.springdata.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ClienteService {

    ClienteRepository clienteRepository;


    public ClienteDto obtenerClientePorIdentificacion(String identificacion) {
        Cliente cliente = clienteRepository.findClienteByIdentificacion(identificacion);

        return fromClienteToDto(cliente);
    }


    public ClienteDto obtenerClienteById(int idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente);

        ClienteDto clienteDto = new ClienteDto();

        clienteDto.setId(cliente.getId());
        clienteDto.setIdentificacion(cliente.getIdentificacion());
        clienteDto.setNombre(cliente.getNombre());
        clienteDto.setApellido(cliente.getApellido());
        clienteDto.setPaisResidencia(cliente.getPaisResidencia());
        clienteDto.setPaisNacimiento(cliente.getPaisNacimiento());
        clienteDto.setDireccionDomicilio(cliente.getDireccionDomicilio());
        clienteDto.setTelefonoContacto(cliente.getTelefonoContacto());
        clienteDto.setEstado(cliente.getEstado());

        return clienteDto;
    }


    public void desactivarClientesActivos(int idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente);

        cliente.setEstado(false);
        clienteRepository.save(cliente);
    }

    public ClienteDto actualizarCliente(ClienteDto clienteDto) {
        Cliente cliente = clienteRepository.findById(clienteDto.getId());

        //cliente.setId(clienteDto.getId());
        cliente.setPaisNacimiento(clienteDto.getPaisResidencia());
        cliente.setDireccionDomicilio(clienteDto.getDireccionDomicilio());
        cliente.setTelefonoContacto(clienteDto.getTelefonoContacto());
        clienteRepository.save(cliente);
        return clienteDto;


    }

    ;

    public void insertarCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setIdentificacion(clienteDto.getIdentificacion());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setPaisResidencia(clienteDto.getPaisResidencia());
        cliente.setPaisNacimiento(clienteDto.getPaisNacimiento());
        cliente.setDireccionDomicilio(clienteDto.getDireccionDomicilio());
        cliente.setTelefonoContacto(clienteDto.getTelefonoContacto());
        cliente.setEstado(clienteDto.getEstado());
        clienteRepository.save(cliente);

    }

    private ClienteDto fromClienteToDto(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }

    public List<ClienteDto> obtenerClientes() {
        return clienteRepository.findAll()
                .stream().map(this::fromClienteToDto).collect(Collectors.toList());

    }

}
