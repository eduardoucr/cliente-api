package com.demo.cliente.api.springdata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String identificacion;
    private String nombre;

    private String apellido;

    private String paisResidencia;
    private String paisNacimiento;
    private String direccionDomicilio;
    private String telefonoContacto;

    private Boolean estado;



}
