package com.codigo.ArqHexagonal.application.service;

import com.codigo.ArqHexagonal.domain.model.FacturaCabecera;
import com.codigo.ArqHexagonal.domain.ports.in.FacturaCabeceraIn;

import java.util.List;
import java.util.Optional;

public class FacturaCabeceraService implements FacturaCabeceraIn {
    private final FacturaCabeceraIn facturaCabeceraIn;
    public FacturaCabeceraService(FacturaCabeceraIn facturaCabeceraIn){
        this.facturaCabeceraIn = facturaCabeceraIn;
    }
    @Override
    public FacturaCabecera createFacturaCabecera(FacturaCabecera facturaCabecera) {
        return facturaCabeceraIn.createFacturaCabecera(facturaCabecera);
    }

    @Override
    public List<FacturaCabecera> showFacturaCabecera() {
        return facturaCabeceraIn.showFacturaCabecera();
    }

    @Override
    public Optional<FacturaCabecera> findFacturaCabeceraById(Long id) {
        return facturaCabeceraIn.findFacturaCabeceraById(id);
    }

    @Override
    public Optional<FacturaCabecera> updateFacturaCabecera(Long id, FacturaCabecera facturaCabecera) {
        return facturaCabeceraIn.updateFacturaCabecera(id, facturaCabecera);
    }

    @Override
    public boolean deleteFacturaCabecera(Long id) {
        return facturaCabeceraIn.deleteFacturaCabecera(id);
    }
}
