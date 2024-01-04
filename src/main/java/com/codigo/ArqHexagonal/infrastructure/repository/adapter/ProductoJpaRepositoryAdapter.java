package com.codigo.ArqHexagonal.infrastructure.repository.adapter;

import com.codigo.ArqHexagonal.domain.model.Producto;
import com.codigo.ArqHexagonal.domain.ports.out.ProductoOut;
import com.codigo.ArqHexagonal.infrastructure.entity.ProductoEntity;
import com.codigo.ArqHexagonal.infrastructure.repository.ProductoJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component

public class ProductoJpaRepositoryAdapter implements ProductoOut {

    private final ProductoJpaRepository productoJpaRepository;
    public ProductoJpaRepositoryAdapter (ProductoJpaRepository productoJpaRepository){
        this.productoJpaRepository = productoJpaRepository;
    }

    @Override
    public Producto crearProduct(Producto producto) {
        ProductoEntity productoEntity = ProductoEntity.fromDomainModel(producto);
        return productoJpaRepository.save(productoEntity).toDomainModel();
    }

    @Override
    public List<Producto> mostrarProductos() {
        return productoJpaRepository.findAll().stream().map(ProductoEntity:: toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Producto> buscarProductById(Long id) {
        Optional<ProductoEntity> productoEntity = productoJpaRepository.findById(id);
        if(productoEntity.isPresent())
        {
            return Optional.of(productoEntity.get().toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Producto> actualizarProduct(Long id, Producto producto) {
    if(productoJpaRepository.existsById(id)){
        ProductoEntity productoEntity = ProductoEntity.fromDomainModel(producto);
        return Optional.of(productoJpaRepository.save(productoEntity).toDomainModel());
    }
        return Optional.empty();
    }

    @Override
    public boolean borrarProduct(Long id) {
        if (productoJpaRepository.existsById(id)){
            productoJpaRepository.deleteById(id);
             return true;
        }
        return false;
    }
}
