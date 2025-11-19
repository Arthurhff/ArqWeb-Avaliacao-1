package com.example.empresa.controller.rest;

import com.example.empresa.model.Funcionario;
import com.example.empresa.service.FuncionarioService;
import com.example.empresa.service.DepartamentoService;
import com.example.empresa.model.Departamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioRestController {
    private final FuncionarioService service;
    private final DepartamentoService deptService;

    public FuncionarioRestController(FuncionarioService service, DepartamentoService deptService) { this.service = service; this.deptService = deptService; }

    @PostMapping
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario f) {
        if (f.getDepartamento() != null && f.getDepartamento().getId() != null) {
            Departamento d = deptService.findById(f.getDepartamento().getId()).orElse(null);
            f.setDepartamento(d);
        }
        return ResponseEntity.ok(service.save(f));
    }

    @GetMapping
    public List<Funcionario> all() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<Funcionario> get(@PathVariable Long id) { return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @RequestBody Funcionario f) {
        return service.findById(id).map(orig -> {
            orig.setNome(f.getNome());
            orig.setEmail(f.getEmail());
            orig.setDataAdmissao(f.getDataAdmissao());
            if (f.getDepartamento() != null && f.getDepartamento().getId()!=null) {
                orig.setDepartamento(deptService.findById(f.getDepartamento().getId()).orElse(null));
            }
            return ResponseEntity.ok(service.save(orig));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.deleteById(id); return ResponseEntity.noContent().build(); }
}
