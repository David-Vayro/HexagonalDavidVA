package com.codigo.ArqHexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Producto {
    private Long producto_id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;


}
