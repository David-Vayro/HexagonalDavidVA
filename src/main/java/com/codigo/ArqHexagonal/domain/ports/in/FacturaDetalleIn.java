package com.codigo.ArqHexagonal.domain.ports.in;

import com.codigo.ArqHexagonal.domain.model.FacturaDetalle;
import com.codigo.ArqHexagonal.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface FacturaDetalleIn {
    FacturaDetalle createFacturaDetalle(FacturaDetalle facturaDetalle);
    List<FacturaDetalle> showFacturaDetalle();
    Optional<FacturaDetalle> findFacturaDetalleById(Long id);
    Optional<FacturaDetalle> updateFacturaDetalle(Long id, FacturaDetalle facturaDetalle);
    boolean deleteFacturaDetalle(Long id);
}
