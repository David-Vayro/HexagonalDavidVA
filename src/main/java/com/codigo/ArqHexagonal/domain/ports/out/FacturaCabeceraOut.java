package com.codigo.ArqHexagonal.domain.ports.out;

import com.codigo.ArqHexagonal.domain.model.FacturaCabecera;

import java.util.List;
import java.util.Optional;

public interface FacturaCabeceraOut {
    FacturaCabecera crearFacturaCabecera(FacturaCabecera facturaCabecera);
    List<FacturaCabecera> mostrarFacturaCabecera();
    Optional<FacturaCabecera> buscarFacturaCabeceraById(Long id);
    Optional<FacturaCabecera> actualizarFacturaCabecera(Long id, FacturaCabecera facturaCabecera);
    boolean borrarFacturaCabecera(Long id);

}
