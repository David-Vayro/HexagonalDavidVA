package com.codigo.ArqHexagonal.domain.ports.in;


import com.codigo.ArqHexagonal.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoIn {
     Producto createProduct(Producto producto);
     List<Producto> showProductos();
    Optional<Producto> findProductById(Long id);
    Optional<Producto> updateProduct(Long id, Producto producto);
    boolean deleteProduct(Long id);

}
