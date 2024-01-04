package com.codigo.ArqHexagonal.application.usecase;



import com.codigo.ArqHexagonal.domain.model.FacturaDetalle;
import com.codigo.ArqHexagonal.domain.ports.in.FacturaDetalleIn;
import com.codigo.ArqHexagonal.domain.ports.out.FacturaDetalleOut;


import java.util.List;
import java.util.Optional;

public class FacturaDetalleServiceImp implements FacturaDetalleIn {

private final FacturaDetalleOut facturaDetalleOut;

    public FacturaDetalleServiceImp(FacturaDetalleOut facturaDetalleOut) {
        this.facturaDetalleOut = facturaDetalleOut;
    }

    @Override
    public FacturaDetalle createFacturaDetalle(FacturaDetalle facturaDetalle) {
        return facturaDetalleOut.crearFacturaDetalle(facturaDetalle);
    }

    @Override
    public List<FacturaDetalle> showFacturaDetalle() {
        return facturaDetalleOut.mostrarFacturaDetalle();
    }

    @Override
    public Optional<FacturaDetalle> findFacturaDetalleById(Long id) {
        return facturaDetalleOut.buscarFacturaDetalleById(id);
    }

    @Override
    public Optional<FacturaDetalle> updateFacturaDetalle(Long id, FacturaDetalle facturaDetalle) {
        return facturaDetalleOut.actualizarFacturaDetalle(id, facturaDetalle);
    }

    @Override
    public boolean deleteFacturaDetalle(Long id) {
        return facturaDetalleOut.borrarFacturaDetalle(id);
    }
}
