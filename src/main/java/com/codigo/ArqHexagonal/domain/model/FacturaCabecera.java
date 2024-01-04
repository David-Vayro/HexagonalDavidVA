package com.codigo.ArqHexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacturaCabecera {
    private Long factura_id;
    private String nombreCliente;
    private int documentoCliente;
    private Date fechaEmision;
    private double total;


}
