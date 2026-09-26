package com.devshowcase.deveshowcase_pi.controller;

import com.devshowcase.deveshowcase_pi.dto.ProjetoRequest;
import com.devshowcase.deveshowcase_pi.model.Projeto;
import com.devshowcase.deveshowcase_pi.service.ProjetoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {

    private final ProjetoService service;

    public ProjetoController(ProjetoService service) {
        this.service = service;
    }

    // Endpoint para redirecionar para o seu portfólio no GitHub Pages
    @GetMapping("/portfolio")
    public RedirectView redirecionarParaPortfolio() {
        return new RedirectView("https://rafaelsoarestes.github.io/meu-portfolio-html/");
    }

    @GetMapping
    public List<Projeto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Projeto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Projeto salvar(@RequestBody ProjetoRequest dados) {
        return service.salvar(dados);
    }

    @PutMapping("/{id}")
    public Projeto atualizar(
            @PathVariable Long id,
            @RequestBody ProjetoRequest dados) {
        return service.atualizar(id, dados);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}