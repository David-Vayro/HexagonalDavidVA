package com.codigo.ArqHexagonal.infrastructure.controller;

import com.codigo.ArqHexagonal.application.service.ProductoService;
import com.codigo.ArqHexagonal.domain.model.Producto;
import com.codigo.ArqHexagonal.infrastructure.entity.ProductoEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/producto")
public class ProductoController {
private final ProductoService productoService;
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
@PostMapping
public ResponseEntity<Producto> createProducto(@RequestBody Producto producto){
Producto createProducto = productoService.createProduct(producto);
return new ResponseEntity<>(createProducto, HttpStatus.CREATED);
}
@GetMapping
public ResponseEntity<List<Producto>> getAllProductos(@PathVariable Long id){
         List<Producto> producto= productoService.showProductos();
         return new ResponseEntity<>(producto, HttpStatus.OK);
}
@GetMapping ("/{Id}")
public ResponseEntity<Producto> getProductoById(@PathVariable Long id){
return productoService.findProductById(id).map(producto -> new ResponseEntity<>(producto,HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}
@PutMapping ("/{Id}")
public ResponseEntity<Producto> updateProducto(@PathVariable Long producto_id, @RequestBody Producto producto){
return productoService.updateProduct(producto_id, producto)
        .map(productoActualizado -> new ResponseEntity<>(productoActualizado, HttpStatus.ACCEPTED))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}
@DeleteMapping("/{Id}")
public ResponseEntity<Producto> deleteProducto(@PathVariable Long id){
    if(productoService.deleteProduct(id)){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
}
