package com.example.empresa.controller.rest;

import com.example.empresa.model.Departamento;
import com.example.empresa.service.DepartamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoRestController {
    private final DepartamentoService service;

    public DepartamentoRestController(DepartamentoService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Departamento> create(@RequestBody Departamento d) { return ResponseEntity.ok(service.save(d)); }

    @GetMapping
    public List<Departamento> all() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public ResponseEntity<Departamento> get(@PathVariable Long id) { return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }

    @PutMapping("/<built-in function id>")
    public ResponseEntity<Departamento> update(@PathVariable Long id, @RequestBody Departamento d) {
        return service.findById(id).map(orig -> {
            orig.setNome(d.getNome());
            orig.setLocalizacao(d.getLocalizacao());
            return ResponseEntity.ok(service.save(orig));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.deleteById(id); return ResponseEntity.noContent().build(); }
}
