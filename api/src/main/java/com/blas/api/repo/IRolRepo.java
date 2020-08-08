package com.blas.api.repo;

import com.blas.api.model.Rol;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IRolRepo extends JpaRepository<Rol, Integer> {

    @Query(value = "SELECT * FROM rol u WHERE UPPER(u.nombre_rol) like %?1% LIMIT ?2 OFFSET ?3", nativeQuery = true)
    public List<Rol> findByFilter(String texto, int limit, int offset);
}
