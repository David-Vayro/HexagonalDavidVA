package com.codigo.ArqHexagonal.infrastructure.repository;

import com.codigo.ArqHexagonal.infrastructure.entity.FacturaCabeceraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaCabeceraJpaRepository extends JpaRepository<FacturaCabeceraEntity, Long> {
}
