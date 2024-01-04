package com.codigo.ArqHexagonal.infrastructure.repository;

import com.codigo.ArqHexagonal.infrastructure.entity.FacturaDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaDetalleJpaRepository extends JpaRepository<FacturaDetalleEntity, Long> {
}
