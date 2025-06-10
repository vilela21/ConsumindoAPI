package com.example.apicep.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.apicep.model.FuncionarioModel;
import com.example.apicep.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<FuncionarioModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<FuncionarioModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public FuncionarioModel salvar(FuncionarioModel funcionario) {
        return repository.save(funcionario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}