package com.demo.cliente.api.springdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

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
