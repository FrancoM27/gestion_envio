package com.gestion_envios.original.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Envio {
    private int idEnvio;
    private String origen;
    private String destino;
    private String estado;
    private String fechaEnvio;
    private String fechaEntrega; 
}
