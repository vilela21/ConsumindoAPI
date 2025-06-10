package com.example.apicep.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.apicep.model.CargoModel;
import com.example.apicep.repository.CargoRepository;

@Service
public class CargoService {

    @Autowired
    private CargoRepository repository;

    public List<CargoModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<CargoModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public CargoModel salvar(CargoModel cargo) {
        return repository.save(cargo);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}