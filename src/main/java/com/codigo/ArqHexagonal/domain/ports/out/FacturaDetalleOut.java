package com.codigo.ArqHexagonal.domain.ports.out;

import com.codigo.ArqHexagonal.domain.model.FacturaDetalle;

import java.util.List;
import java.util.Optional;

public interface FacturaDetalleOut {
    FacturaDetalle crearFacturaDetalle(FacturaDetalle facturaDetalle);

    List<FacturaDetalle> mostrarFacturaDetalle();

    Optional<FacturaDetalle> buscarFacturaDetalleById(Long id);

    Optional<FacturaDetalle> actualizarFacturaDetalle(Long id, FacturaDetalle facturaDetalle);
    boolean borrarFacturaDetalle(Long id);
}
