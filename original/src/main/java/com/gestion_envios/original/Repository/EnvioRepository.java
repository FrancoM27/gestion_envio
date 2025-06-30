package com.gestion_envios.original.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion_envios.original.Model.Entity.EnvioEntity;

@Repository
public interface EnvioRepository extends JpaRepository<EnvioEntity, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, encontrar envíos por estado o por fecha
    EnvioEntity findByIdEnvio(int idEnvio); 
    boolean existsByIdEnvio(int idEnvio); 
    // List<EnvioEntity> findByFechaEnvioBetween(String startDate, String endDate);
    void deleteByIdEnvio(int i); 
   
}
