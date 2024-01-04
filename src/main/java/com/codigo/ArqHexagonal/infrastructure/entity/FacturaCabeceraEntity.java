package com.codigo.ArqHexagonal.infrastructure.entity;

import com.codigo.ArqHexagonal.domain.model.FacturaCabecera;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name="facturaCabecera")
public class FacturaCabeceraEntity {
    @Id
    @Column(name="factura_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long factura_id;
    @Column(name="cliente_nombre")
    private String nombreCliente;
    @Column(name="cliente_num_documento")
    private int documentoCliente;
    @Column(name="fecha_emision")
    private Date fechaEmision;
    @Column(name="total")
    private double total;

    @OneToMany(mappedBy = "facturaCabecera", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<FacturaDetalleEntity> facturaDetalleEntitySet = new HashSet<>();


    public FacturaCabeceraEntity() {
    }

    public FacturaCabeceraEntity(Long factura_id, String nombreCliente, int documentoCliente, Date fechaEmision, double total) {
        this.factura_id = factura_id;
        this.nombreCliente = nombreCliente;
        this.documentoCliente = documentoCliente;
        this.fechaEmision = fechaEmision;
        this.total = total;
    }

    public static FacturaCabeceraEntity fromDomainModel(FacturaCabecera facturaCabecera){
    return new FacturaCabeceraEntity(facturaCabecera.getFactura_id(), facturaCabecera.getNombreCliente(),
            facturaCabecera.getDocumentoCliente(),facturaCabecera.getFechaEmision(),facturaCabecera.getTotal());
}
public FacturaCabecera toDomainModel(){
    return new FacturaCabecera(factura_id, nombreCliente, documentoCliente, fechaEmision, total);
}
}
