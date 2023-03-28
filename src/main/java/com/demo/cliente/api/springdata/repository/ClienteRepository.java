package com.demo.cliente.api.springdata.repository;

import com.demo.cliente.api.springdata.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> , JpaSpecificationExecutor<Cliente> {
    List<Cliente> findAll();
    Cliente findClienteByIdentificacion(String identificacion);
  //  List<Cliente> findByCliente_IdAndEstadoIsTrue(int clienteId);
    Cliente findById(int id);

}
