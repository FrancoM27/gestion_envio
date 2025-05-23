package com.gestion_envios.original.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion_envios.original.Model.Envio;
import com.gestion_envios.original.Service.EnvioService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController

public class EnvioController {
    @Autowired
    private EnvioService envioService;

    @PostMapping("/crearEnvio")
    public ResponseEntity<String> crearEnvio(@RequestBody Envio envio) {
        return ResponseEntity.ok(envioService.crearEnvio(envio)); 
    }

    @PutMapping("/actualizarEnvio/{idEnvio}")
    public ResponseEntity<String> actualizarEnvio(@PathVariable int idEnvio) {
        return ResponseEntity.ok(envioService.actualizarEnvio(idEnvio));
    }

    @GetMapping("/obtenerEnvio/{idEnvio}")
    public ResponseEntity<Envio> obtenerEnvio(@PathVariable int idEnvio) {
        Envio envio = envioService.obtenerEnvio(idEnvio);
        if (envio != null) {
            return ResponseEntity.ok(envio);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/listarEnvios")
    public ResponseEntity<List<Envio>> listarEnvios() {
        List<Envio> envios = envioService.listarEnvios();
        if (!envios.isEmpty()) {
            return ResponseEntity.ok(envios);
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminarEnvio/{idEnvio}")
    public ResponseEntity<String> eliminarEnvio(@PathVariable int idEnvio) {
        return ResponseEntity.ok(envioService.eliminarEnvio(idEnvio)); 
    }
}
