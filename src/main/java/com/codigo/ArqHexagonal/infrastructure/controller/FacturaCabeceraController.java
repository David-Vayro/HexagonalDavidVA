package com.codigo.ArqHexagonal.infrastructure.controller;

import com.codigo.ArqHexagonal.application.service.FacturaCabeceraService;
import com.codigo.ArqHexagonal.domain.model.FacturaCabecera;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/facturaCabecera")
public class FacturaCabeceraController {
    private final FacturaCabeceraService facturaCabeceraService;


    public FacturaCabeceraController(FacturaCabeceraService facturaCabeceraService) {
        this.facturaCabeceraService = facturaCabeceraService;
    }
    @PostMapping
    public ResponseEntity<FacturaCabecera> createFacturaCabecera(@RequestBody FacturaCabecera facturaCabecera){
        FacturaCabecera createFacturaCabecera = facturaCabeceraService.createFacturaCabecera(facturaCabecera);
        return new ResponseEntity<>(createFacturaCabecera, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<FacturaCabecera>> getAllFacturaCabecera(){
        List<FacturaCabecera> facturaCabecera= facturaCabeceraService.showFacturaCabecera();
        return new ResponseEntity<>(facturaCabecera, HttpStatus.OK);
    }
    @GetMapping ("/{id}")
    public ResponseEntity<FacturaCabecera> getFacturaCabeceraById(@PathVariable Long id){
        return facturaCabeceraService.findFacturaCabeceraById(id).map(producto -> new ResponseEntity<>(producto,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping ("/{id}")
    public ResponseEntity<FacturaCabecera> updateFacturaCabecera(@PathVariable Long id, @RequestBody FacturaCabecera facturaCabecera){
        return facturaCabeceraService.updateFacturaCabecera(id, facturaCabecera)
                .map(facturaCabecera1 -> new ResponseEntity<>(facturaCabecera1, HttpStatus.ACCEPTED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<FacturaCabecera> deleteFacturaCabecera(@PathVariable Long id){
        if(facturaCabeceraService.deleteFacturaCabecera(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
