package com.example.empresa.service;

import com.example.empresa.model.Funcionario;
import com.example.empresa.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository repo;

    public FuncionarioService(FuncionarioRepository repo) {
        this.repo = repo;
    }

    public Funcionario save(Funcionario f) { return repo.save(f); }
    public List<Funcionario> findAll() { return repo.findAll(); }
    public Optional<Funcionario> findById(Long id) { return repo.findById(id); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
