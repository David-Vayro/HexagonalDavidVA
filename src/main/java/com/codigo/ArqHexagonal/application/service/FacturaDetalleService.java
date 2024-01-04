package com.codigo.ArqHexagonal.application.service;

import com.codigo.ArqHexagonal.domain.model.FacturaDetalle;
import com.codigo.ArqHexagonal.domain.ports.in.FacturaDetalleIn;

import java.util.List;
import java.util.Optional;

public class FacturaDetalleService implements FacturaDetalleIn {
    private final FacturaDetalleIn facturaDetalleIn;

    public FacturaDetalleService(FacturaDetalleIn facturaDetalleIn) {
        this.facturaDetalleIn = facturaDetalleIn;
    }

    @Override
    public FacturaDetalle createFacturaDetalle(FacturaDetalle facturaDetalle) {
        return facturaDetalleIn.createFacturaDetalle(facturaDetalle);
    }

    @Override
    public List<FacturaDetalle> showFacturaDetalle() {
        return facturaDetalleIn.showFacturaDetalle();
    }

    @Override
    public Optional<FacturaDetalle> findFacturaDetalleById(Long id) {
        return facturaDetalleIn.findFacturaDetalleById(id);
    }

    @Override
    public Optional<FacturaDetalle> updateFacturaDetalle(Long id, FacturaDetalle facturaDetalle) {
        return facturaDetalleIn.updateFacturaDetalle(id, facturaDetalle);
    }

    @Override
    public boolean deleteFacturaDetalle(Long id) {
        return facturaDetalleIn.deleteFacturaDetalle(id);
    }

}
