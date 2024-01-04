package com.codigo.ArqHexagonal.domain.ports.out;

import com.codigo.ArqHexagonal.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoOut {
    Producto crearProduct(Producto producto);
    List<Producto> mostrarProductos();
    Optional<Producto> buscarProductById(Long id);
    Optional<Producto> actualizarProduct(Long id, Producto producto);
    boolean borrarProduct(Long id);
}
