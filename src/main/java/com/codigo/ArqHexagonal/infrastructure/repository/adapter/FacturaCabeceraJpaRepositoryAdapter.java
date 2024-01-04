package com.codigo.ArqHexagonal.infrastructure.repository.adapter;

import com.codigo.ArqHexagonal.domain.model.FacturaCabecera;
import com.codigo.ArqHexagonal.domain.ports.out.FacturaCabeceraOut;
import com.codigo.ArqHexagonal.infrastructure.entity.FacturaCabeceraEntity;
import com.codigo.ArqHexagonal.infrastructure.repository.FacturaCabeceraJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FacturaCabeceraJpaRepositoryAdapter implements FacturaCabeceraOut {
    private final FacturaCabeceraJpaRepository facturaCabeceraJpaRepository;

    public FacturaCabeceraJpaRepositoryAdapter(FacturaCabeceraJpaRepository facturaCabeceraJpaRepository) {
        this.facturaCabeceraJpaRepository = facturaCabeceraJpaRepository;
    }


    @Override
    public FacturaCabecera crearFacturaCabecera(FacturaCabecera facturaCabecera) {
        FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromDomainModel(facturaCabecera);
        return facturaCabeceraJpaRepository.save(facturaCabeceraEntity).toDomainModel();
    }

    @Override
    public List<FacturaCabecera> mostrarFacturaCabecera() {
        return facturaCabeceraJpaRepository.findAll().stream().map(FacturaCabeceraEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<FacturaCabecera> buscarFacturaCabeceraById(Long id) {

        return facturaCabeceraJpaRepository.findById(id).map(FacturaCabeceraEntity::toDomainModel);
    }

    @Override
    public Optional<FacturaCabecera> actualizarFacturaCabecera(Long id, FacturaCabecera facturaCabecera) {
        if (facturaCabeceraJpaRepository.existsById(facturaCabecera.getFactura_id())){
            FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromDomainModel(facturaCabecera);
            FacturaCabeceraEntity actualizarCabeceraEntity = facturaCabeceraJpaRepository.save(facturaCabeceraEntity);
            return Optional.of(actualizarCabeceraEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean borrarFacturaCabecera(Long id) {
        if (facturaCabeceraJpaRepository.existsById(id)){
            facturaCabeceraJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
