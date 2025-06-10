package com.example.apicep.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.apicep.model.UsuarioModel;
import com.example.apicep.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<UsuarioModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public UsuarioModel salvar(UsuarioModel usuarios) {
        return repository.save(usuarios);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}