package com.codigo.ArqHexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDetalle {
        private Long detalle_id;
        private FacturaCabecera facturaCabecera;
        private Producto producto;
        private int cantidad;
        private double precioUnitario;
        private double subtotal;
}
