package com.devshowcase.deveshowcase_pi.model;

import jakarta.persistence.*;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String tecnologia;
    private String urlRepositorio;
    private String urlDemo;

    // Construtor vazio (obrigatório para o JPA)
    public Projeto() {
    }

    // Construtor com parâmetros (usado no método salvar)
    public Projeto(String nome, String descricao, String tecnologia, String urlRepositorio, String urlDemo) {
        this.nome = nome;
        this.descricao = descricao;
        this.tecnologia = tecnologia;
        this.urlRepositorio = urlRepositorio;
        this.urlDemo = urlDemo;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getUrlRepositorio() {
        return urlRepositorio;
    }

    public void setUrlRepositorio(String urlRepositorio) {
        this.urlRepositorio = urlRepositorio;
    }

    public String getUrlDemo() {
        return urlDemo;
    }

    public void setUrlDemo(String urlDemo) {
        this.urlDemo = urlDemo;
    }
}