package com.codigo.ArqHexagonal.infrastructure.repository;

import com.codigo.ArqHexagonal.infrastructure.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoJpaRepository extends JpaRepository<ProductoEntity, Long> {
}
