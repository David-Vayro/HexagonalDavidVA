package com.codigo.ArqHexagonal.infrastructure.config;

import com.codigo.ArqHexagonal.application.service.FacturaCabeceraService;
import com.codigo.ArqHexagonal.application.service.FacturaDetalleService;
import com.codigo.ArqHexagonal.application.service.ProductoService;
import com.codigo.ArqHexagonal.application.usecase.FacturaCabeceraServiceImp;
import com.codigo.ArqHexagonal.application.usecase.FacturaDetalleServiceImp;
import com.codigo.ArqHexagonal.application.usecase.ProductoServiceImp;
import com.codigo.ArqHexagonal.domain.ports.out.FacturaCabeceraOut;
import com.codigo.ArqHexagonal.domain.ports.out.FacturaDetalleOut;
import com.codigo.ArqHexagonal.domain.ports.out.ProductoOut;
import com.codigo.ArqHexagonal.infrastructure.repository.adapter.FacturaCabeceraJpaRepositoryAdapter;
import com.codigo.ArqHexagonal.infrastructure.repository.adapter.FacturaDetalleJpaRepositoryAdapter;
import com.codigo.ArqHexagonal.infrastructure.repository.adapter.ProductoJpaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public FacturaCabeceraService facturaCabeceraService(FacturaCabeceraOut facturaCabeceraOut) {
        return new FacturaCabeceraService(new FacturaCabeceraServiceImp(facturaCabeceraOut));
    }

    @Bean
    public FacturaCabeceraOut facturaCabeceraOut(FacturaCabeceraJpaRepositoryAdapter facturaCabeceraJpaRepositoryAdapter) {
        return facturaCabeceraJpaRepositoryAdapter;
    }

    @Bean
    public ProductoService productoService(ProductoOut productoOut) {
        return new ProductoService(new ProductoServiceImp(productoOut));
    }

    @Bean
    public ProductoOut productoOut(ProductoJpaRepositoryAdapter productoJpaRepositoryAdapter) {
        return productoJpaRepositoryAdapter;
    }

    @Bean
    public FacturaDetalleService facturaDetalleService(FacturaDetalleOut facturaDetalleOut) {
        return new FacturaDetalleService(new FacturaDetalleServiceImp(facturaDetalleOut));
    }

    @Bean
    public FacturaDetalleOut facturaDetalleOut(FacturaDetalleJpaRepositoryAdapter facturaDetalleJpaRepositoryAdapter) {
        return facturaDetalleJpaRepositoryAdapter;
    }

}
