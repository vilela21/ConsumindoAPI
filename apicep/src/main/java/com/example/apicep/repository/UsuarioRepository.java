
package com.example.apicep.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 

import com.example.apicep.model.UsuariosModel;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosModel, Long> {
}
