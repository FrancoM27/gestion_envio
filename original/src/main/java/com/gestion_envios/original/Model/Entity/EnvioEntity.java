package com.gestion_envios.original.Model.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id;  
import lombok.Data;

@Entity
@EntityScan
@Data

public class EnvioEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnvio;
    @Column(name = "origen")
    private String origen;

    private String destino;
    private String estado;
    private String fechaEnvio;
    private String fechaEntrega; 
}
