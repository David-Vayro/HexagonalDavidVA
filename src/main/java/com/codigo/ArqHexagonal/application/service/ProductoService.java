package com.codigo.ArqHexagonal.application.service;

import com.codigo.ArqHexagonal.domain.model.Producto;
import com.codigo.ArqHexagonal.domain.ports.in.ProductoIn;

import java.util.List;
import java.util.Optional;

public class ProductoService implements ProductoIn {
    private final ProductoIn productoIn;
    public ProductoService(ProductoIn productoIn){
        this.productoIn = productoIn;
    }

    @Override
    public Producto createProduct(Producto producto) {
        return productoIn.createProduct(producto);
    }

    @Override
    public List<Producto> showProductos() {
        return productoIn.showProductos();
    }

    @Override
    public Optional<Producto> findProductById(Long id) {
        return productoIn.findProductById(id);
    }

    @Override
    public Optional<Producto> updateProduct(Long id, Producto producto) {
        return productoIn.updateProduct(id, producto);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return productoIn.deleteProduct(id);
    }
}
