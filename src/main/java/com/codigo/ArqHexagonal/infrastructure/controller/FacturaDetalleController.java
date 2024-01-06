package com.codigo.ArqHexagonal.infrastructure.controller;

import com.codigo.ArqHexagonal.application.service.FacturaDetalleService;
import com.codigo.ArqHexagonal.domain.model.FacturaCabecera;
import com.codigo.ArqHexagonal.domain.model.FacturaDetalle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/facturaDetalle")
public class FacturaDetalleController {
    private FacturaDetalleService facturaDetalleService;

    public FacturaDetalleController(FacturaDetalleService facturaDetalleService) {
        this.facturaDetalleService = facturaDetalleService;
    }
    @PostMapping
    public ResponseEntity<FacturaDetalle> createFacturaDetalle(@RequestBody FacturaDetalle facturaDetalle){
        FacturaDetalle createFacturaDetalle = facturaDetalleService.createFacturaDetalle(facturaDetalle);
        return new ResponseEntity<>(createFacturaDetalle, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<FacturaDetalle>> getAllFacturaDetalle(){
        List<FacturaDetalle> facturaDetalle= facturaDetalleService.showFacturaDetalle();
        return new ResponseEntity<>(facturaDetalle, HttpStatus.OK);
    }
    @GetMapping ("/{id}")
    public ResponseEntity<FacturaDetalle> getFacturaDetalleById(@PathVariable Long id){
        return facturaDetalleService.findFacturaDetalleById(id).map(producto -> new ResponseEntity<>(producto,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{id}")
    public ResponseEntity<FacturaDetalle> updateFacturaDetalle(@PathVariable Long id, @RequestBody FacturaDetalle facturaDetalle){
        return facturaDetalleService.updateFacturaDetalle(id, facturaDetalle)
                .map(facturaDetalle1 -> new ResponseEntity<>(facturaDetalle1, HttpStatus.ACCEPTED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<FacturaDetalle> deleteFacturaDetalle(@PathVariable Long id){
        if(facturaDetalleService.deleteFacturaDetalle(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
