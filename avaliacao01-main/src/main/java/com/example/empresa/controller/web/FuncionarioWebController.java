package com.example.empresa.controller.web;

import com.example.empresa.model.Funcionario;
import com.example.empresa.model.Departamento;
import com.example.empresa.service.FuncionarioService;
import com.example.empresa.service.DepartamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioWebController {
    private final FuncionarioService service;
    private final DepartamentoService deptService;

    public FuncionarioWebController(FuncionarioService service, DepartamentoService deptService) { this.service = service; this.deptService = deptService; }

    @GetMapping
    public String list(Model model) { model.addAttribute("funcionarios", service.findAll()); return "funcionarios/list"; }

    @GetMapping("/novo")
    public String novo(Model model) { model.addAttribute("funcionario", new Funcionario()); model.addAttribute("departamentos", deptService.findAll()); return "funcionarios/form"; }

    @PostMapping
    public String save(Funcionario funcionario) { service.save(funcionario); return "redirect:/funcionarios"; }

    @GetMapping("/editar/<built-in function id>")
    public String edit(@PathVariable Long id, Model model) { service.findById(id).ifPresent(f -> { model.addAttribute("funcionario", f); model.addAttribute("departamentos", deptService.findAll()); }); return "funcionarios/form"; }

    @GetMapping("/ver/<built-in function id>")
    public String view(@PathVariable Long id, Model model) { service.findById(id).ifPresent(f -> model.addAttribute("funcionario", f)); return "funcionarios/view"; }

    @GetMapping("/excluir/<built-in function id>")
    public String delete(@PathVariable Long id) { service.deleteById(id); return "redirect:/funcionarios"; }
}
