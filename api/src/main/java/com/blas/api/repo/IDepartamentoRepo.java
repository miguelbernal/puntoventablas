package com.blas.api.repo;

import com.blas.api.model.Departamento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IDepartamentoRepo extends JpaRepository<Departamento, Integer> {

    @Query(value = "SELECT * FROM departamentos d WHERE UPPER(d.nombre_departamento) like %?1% LIMIT ?2 OFFSET ?3", nativeQuery = true)
    public List<Departamento> findByFilter(String texto, int limit, int offset);
}
