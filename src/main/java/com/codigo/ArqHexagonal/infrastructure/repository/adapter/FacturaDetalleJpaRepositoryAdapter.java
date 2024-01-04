package com.codigo.ArqHexagonal.infrastructure.repository.adapter;

import com.codigo.ArqHexagonal.domain.model.FacturaDetalle;
import com.codigo.ArqHexagonal.domain.ports.out.FacturaDetalleOut;
import com.codigo.ArqHexagonal.infrastructure.entity.FacturaDetalleEntity;
import com.codigo.ArqHexagonal.infrastructure.repository.FacturaDetalleJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class FacturaDetalleJpaRepositoryAdapter implements FacturaDetalleOut {
    private final FacturaDetalleJpaRepository facturaDetalleJpaRepository;

    public FacturaDetalleJpaRepositoryAdapter(FacturaDetalleJpaRepository facturaDetalleJpaRepository) {
        this.facturaDetalleJpaRepository = facturaDetalleJpaRepository;
    }

    @Override
    public FacturaDetalle crearFacturaDetalle(FacturaDetalle facturaDetalle) {
        FacturaDetalleEntity facturaDetalleEntity = FacturaDetalleEntity.fromDomainModel(facturaDetalle);
        return facturaDetalleJpaRepository.save(facturaDetalleEntity).toDomainModel();
    }

    @Override
    public List<FacturaDetalle> mostrarFacturaDetalle() {
        return facturaDetalleJpaRepository.findAll().stream().map(FacturaDetalleEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<FacturaDetalle> buscarFacturaDetalleById(Long id) {
        return facturaDetalleJpaRepository.findById(id).map(FacturaDetalleEntity::toDomainModel);
    }

    @Override
    public Optional<FacturaDetalle> actualizarFacturaDetalle(Long id, FacturaDetalle facturaDetalle) {
        if (facturaDetalleJpaRepository.existsById(id)){
            FacturaDetalleEntity facturaDetalleEntity = FacturaDetalleEntity.fromDomainModel(facturaDetalle);
            FacturaDetalleEntity actualizarFacturaDetalle = facturaDetalleJpaRepository.save(facturaDetalleEntity);
            return Optional.of(actualizarFacturaDetalle.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean borrarFacturaDetalle(Long id) {
        if (facturaDetalleJpaRepository.existsById(id)){
            facturaDetalleJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
