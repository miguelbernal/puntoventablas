package com.blas.api.rest;

import java.util.List;
import java.util.Optional;

import com.blas.api.model.Rol;
import com.blas.api.repo.IRolRepo;
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
@RequestMapping("/api/roles")
public class RolRestController {
    @Autowired
    private IRolRepo repo;

    @GetMapping(value ="/{id}")
    public Optional<Rol> findOne(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }

    @GetMapping
    public List<Rol> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public Rol insert(@RequestBody Rol Rol) {
         return repo.save(Rol);
    }

    @PutMapping
    public Rol update(@RequestBody Rol Rol) {
         return repo.save(Rol);
    }

    @DeleteMapping(value="/{id}")
    public Optional<Rol> delete(@PathVariable("id") Integer id) {
        Optional<Rol> rol = repo.findById(id);
        repo.deleteById(id);
        return rol;
    }

    @GetMapping(value = "/filtrar/{texto}/{pagina}")
    public List<Rol> findOptional(@PathVariable("texto") String texto, @PathVariable("pagina") int pagina) {
         System.out.println("***************************" + texto + " - " + pagina);
         // 1-1 = 0 * 10 = 0
         // 2-1 = 1 * 10 = 10
         // 3-1 = 2 * 10 = 20
         if(texto.equals(" ")){
             texto="";
         }
         int limit = 10;
         int offset = (pagina - 1) * limit;
            return repo.findByFilter(texto.toUpperCase(), limit, offset);
    }

}