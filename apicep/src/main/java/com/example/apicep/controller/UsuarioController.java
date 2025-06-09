package com.example.apicep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apicep.model.UsuariosModel;
import com.example.apicep.service.UsuariosService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService service;

    @GetMapping
    public List<UsuariosModel> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UsuariosModel salvar(@RequestBody UsuariosModel usuarios) {
        return service.salvar(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuariosModel> atualizar(@PathVariable Long id, @RequestBody UsuariosModel usuarios) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuarios.setId(id);
        return ResponseEntity.ok(service.salvar(usuarios));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
