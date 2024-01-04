package com.codigo.ArqHexagonal.domain.ports.in;

import com.codigo.ArqHexagonal.domain.model.FacturaCabecera;
import com.codigo.ArqHexagonal.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface FacturaCabeceraIn {
    FacturaCabecera createFacturaCabecera(FacturaCabecera facturaCabecera);
    List<FacturaCabecera> showFacturaCabecera();
    Optional<FacturaCabecera> findFacturaCabeceraById(Long id);
    Optional<FacturaCabecera> updateFacturaCabecera(Long id, FacturaCabecera facturaCabecera);
    boolean deleteFacturaCabecera(Long id);
}
