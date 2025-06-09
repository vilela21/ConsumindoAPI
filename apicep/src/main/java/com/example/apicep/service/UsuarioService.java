package com.example.apicep.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.apicep.model.UsuariosModel;
import com.example.apicep.repository.UsuariosRepository;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository repository;

    public List<UsuariosModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<UsuariosModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public UsuariosModel salvar(UsuariosModel usuarios) {
        return repository.save(usuarios);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}