package com.codigo.ArqHexagonal.application.usecase;

import com.codigo.ArqHexagonal.domain.model.Producto;
import com.codigo.ArqHexagonal.domain.ports.in.ProductoIn;
import com.codigo.ArqHexagonal.domain.ports.out.ProductoOut;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImp implements ProductoIn {
    private  final ProductoOut productoOut;
    public ProductoServiceImp(ProductoOut productoOut){
        this.productoOut = productoOut;
    }
    @Override
    public Producto createProduct(Producto producto) {
        return productoOut.crearProduct(producto);
    }

    @Override
    public List<Producto> showProductos() {
        return productoOut.mostrarProductos();
    }

    @Override
    public Optional<Producto> findProductById(Long id) {
        return productoOut.buscarProductById(id);
    }

    @Override
    public Optional<Producto> updateProduct(Long id, Producto producto) {
        return productoOut.actualizarProduct(id, producto);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return productoOut.borrarProduct(id);
    }
}
