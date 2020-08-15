package com.blas.api.rest;

import java.util.List;
import java.util.Optional;

import com.blas.api.model.Departamento;
import com.blas.api.repo.IDepartamentoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoRestController {
    @Autowired
    private IDepartamentoRepo repo;

    @GetMapping(value ="/{id}")
    public Optional<Departamento> findOne(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }

    @GetMapping
    public List<Departamento> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public Departamento insert(@RequestBody Departamento departamento) {
         return repo.save(departamento);
    }

    @PutMapping
    public Departamento update(@RequestBody Departamento departamento) {
         return repo.save(departamento);
    }

    @DeleteMapping(value="/{id}")
    public Optional<Departamento> delete(@PathVariable("id") Integer id) {
        Optional<Departamento> departamento = repo.findById(id);
        repo.deleteById(id);
        return departamento;
    }

    @GetMapping(value = "/filtrar/{texto}/{pagina}")
    public List<Departamento> findOptional(@PathVariable("texto") String texto, @PathVariable("pagina") int pagina) {
        if(texto.equals(" ")){
             texto="";
        }
        int limit = 10;
        int offset = (pagina - 1) * limit;
        return repo.findByFilter(texto.toUpperCase(), limit, offset);
    }

}