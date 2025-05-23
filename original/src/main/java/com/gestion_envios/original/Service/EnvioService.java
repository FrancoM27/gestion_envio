package com.gestion_envios.original.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion_envios.original.Model.Envio;
import com.gestion_envios.original.Model.Entity.EnvioEntity;
import com.gestion_envios.original.Repository.EnvioRepository;

@Service

public class EnvioService {
    @Autowired
    private EnvioRepository envioRepository;

    public String crearEnvio(Envio env){
        
        try {
            boolean estado = envioRepository.existsByIdEnvio(env.getIdEnvio());
            if (!estado){
                EnvioEntity envioNuevo = new EnvioEntity();
                envioNuevo.setIdEnvio(env.getIdEnvio());
                envioNuevo.setOrigen(env.getOrigen());
                envioNuevo.setDestino(env.getDestino());
                envioNuevo.setEstado(env.getEstado());
                envioNuevo.setFechaEnvio(env.getFechaEnvio());
                envioNuevo.setFechaEntrega(env.getFechaEntrega());
                envioRepository.save(envioNuevo);
                return "Envio creado con exito";
            } 
            return "El envio ya existe";       
        } catch (Exception e) {
            return "Error al crear el envio: ";
        }
    }

    public String actualizarEnvio(int idEnvio){
        try {
            EnvioEntity envioExistente = envioRepository.findByIdEnvio(idEnvio);
            if (envioExistente != null) {
                envioExistente.setEstado("Entregado");
                envioRepository.save(envioExistente);
                return "Envio actualizado con exito";
            }
            return "El envio no existe";
        } catch (Exception e) {
            return "Error al actualizar el envio: ";
        }
    }

    public Envio obtenerEnvio(int idEnvio){
        try {
            EnvioEntity envioExistente = envioRepository.findByIdEnvio(idEnvio);
            if (envioExistente != null) {
                Envio envio = new Envio();
                envio.setIdEnvio(envioExistente.getIdEnvio());
                envio.setOrigen(envioExistente.getOrigen());
                envio.setDestino(envioExistente.getDestino());
                envio.setEstado(envioExistente.getEstado());
                envio.setFechaEnvio(envioExistente.getFechaEnvio());
                envio.setFechaEntrega(envioExistente.getFechaEntrega());
                return envio;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Envio> listarEnvios(){
        try {
            List<EnvioEntity> envios = envioRepository.findAll();
            if (!envios.isEmpty()) {
                List<Envio> listaEnvios = new ArrayList<>();
                for (EnvioEntity envio : envios) {
                    Envio envi = new Envio();
                    envi.setIdEnvio(envio.getIdEnvio());
                    envi.setOrigen(envio.getOrigen());
                    envi.setDestino(envio.getDestino());
                    envi.setEstado(envio.getEstado());
                    envi.setFechaEnvio(envio.getFechaEnvio());
                    envi.setFechaEntrega(envio.getFechaEntrega());
                    listaEnvios.add(envi);
                }
                return listaEnvios;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public String eliminarEnvio(int idEnvio){
        try {
            EnvioEntity envioExistente = envioRepository.findByIdEnvio(idEnvio);
            if (envioExistente != null) {
                envioRepository.delete(envioExistente);
                return "Envio eliminado con exito";
            }
            return "El envio no existe";
        } catch (Exception e) {
            return "Error al eliminar el envio: ";
        }
    }
}
