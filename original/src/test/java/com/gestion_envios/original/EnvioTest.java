package com.gestion_envios.original;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.context.SpringBootTest; 

import com.gestion_envios.original.Model.Envio;
import com.gestion_envios.original.Model.Entity.EnvioEntity;
import com.gestion_envios.original.Repository.EnvioRepository;
import com.gestion_envios.original.Service.EnvioService;

@SpringBootTest 
public class EnvioTest {
     
    @Mock
    private EnvioRepository envioRepository;

    @InjectMocks
    private EnvioService envioService;

    private Envio envio;
    private EnvioEntity envioEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        envio = new Envio(1, "valparaiso", "santiago", "enviado", "01/10/2025", "02/10/2025");
        envioEntity = new EnvioEntity();
        envioEntity.setIdEnvio(1);
        envioEntity.setOrigen("valparaiso");
        envioEntity.setDestino("santiago"); 
        envioEntity.setEstado("enviado");
        envioEntity.setFechaEnvio("01/10/2025");
        envioEntity.setFechaEntrega("02/10/2025");
    }

    @Test
    public void testCrearEnvio() {
        // Simular el comportamiento del repositorio
        when(envioRepository.existsByIdEnvio(envio.getIdEnvio())).thenReturn(false);
        when(envioRepository.save(any(EnvioEntity.class))).thenReturn(envioEntity);

        String result = envioService.crearEnvio(envio);
        assertEquals("Envio creado con exito", result); 
    }    
    
}   