package com.example.empresa.controller.web;

import com.example.empresa.model.Departamento;
import com.example.empresa.service.DepartamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoWebController {
    private final DepartamentoService service;

    public DepartamentoWebController(DepartamentoService service) { this.service = service; }

    @GetMapping
    public String list(Model model) { model.addAttribute("departamentos", service.findAll()); return "departamentos/list"; }

    @GetMapping("/novo")
    public String novo(Model model) { model.addAttribute("departamento", new Departamento()); return "departamentos/form"; }

    @PostMapping
    public String save(Departamento departamento) { service.save(departamento); return "redirect:/departamentos"; }

    @GetMapping("/editar/<built-in function id>")
    public String edit(@PathVariable Long id, Model model) { service.findById(id).ifPresent(d -> model.addAttribute("departamento", d)); return "departamentos/form"; }

    @GetMapping("/ver/<built-in function id>")
    public String view(@PathVariable Long id, Model model) { service.findById(id).ifPresent(d -> model.addAttribute("departamento", d)); return "departamentos/view"; }

    @GetMapping("/excluir/<built-in function id>")
    public String delete(@PathVariable Long id) { service.deleteById(id); return "redirect:/departamentos"; }
}
