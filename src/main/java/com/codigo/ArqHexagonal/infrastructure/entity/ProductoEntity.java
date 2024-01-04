package com.codigo.ArqHexagonal.infrastructure.entity;

import com.codigo.ArqHexagonal.domain.model.Producto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter

@Table(name= "Productos")
public class ProductoEntity {
    @Id
    @Column(name = "producto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long producto_id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private double precio;
    @Column(name = "stock")
    private int stock;
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<FacturaDetalleEntity> facturaDetalleEntitySet = new HashSet<>();

    public ProductoEntity() {
    }

    public ProductoEntity(Long producto_id, String nombre, String descripcion, double precio, int stock) {
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public static ProductoEntity fromDomainModel(Producto producto){
    return new ProductoEntity(producto.getProducto_id(), producto.getNombre(), producto.getDescripcion(),producto.getPrecio(), producto.getStock());
    }
    public Producto toDomainModel(){
        return new Producto(producto_id, nombre, descripcion, precio, stock);

    }

}
