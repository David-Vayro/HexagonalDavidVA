package com.codigo.ArqHexagonal.application.usecase;

import com.codigo.ArqHexagonal.domain.model.FacturaCabecera;
import com.codigo.ArqHexagonal.domain.ports.in.FacturaCabeceraIn;
import com.codigo.ArqHexagonal.domain.ports.out.FacturaCabeceraOut;

import java.util.List;
import java.util.Optional;

public class FacturaCabeceraServiceImp implements FacturaCabeceraIn {
    private final FacturaCabeceraOut facturaCabeceraOut;

    public FacturaCabeceraServiceImp(FacturaCabeceraOut facturaCabeceraOut) {
        this.facturaCabeceraOut = facturaCabeceraOut;
    }

    @Override
    public FacturaCabecera createFacturaCabecera(FacturaCabecera facturaCabecera) {
        return facturaCabeceraOut.crearFacturaCabecera(facturaCabecera);
    }

    @Override
    public List<FacturaCabecera> showFacturaCabecera() {
        return facturaCabeceraOut.mostrarFacturaCabecera();
    }

    @Override
    public Optional<FacturaCabecera> findFacturaCabeceraById(Long id) {
        return facturaCabeceraOut.buscarFacturaCabeceraById(id);
    }

    @Override
    public Optional<FacturaCabecera> updateFacturaCabecera(Long id, FacturaCabecera facturaCabecera) {
        return facturaCabeceraOut.actualizarFacturaCabecera(id, facturaCabecera);
    }

    @Override
    public boolean deleteFacturaCabecera(Long id) {
        return facturaCabeceraOut.borrarFacturaCabecera(id);
    }
}
