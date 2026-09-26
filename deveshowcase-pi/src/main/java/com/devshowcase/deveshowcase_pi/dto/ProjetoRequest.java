package com.devshowcase.deveshowcase_pi.dto;

public record ProjetoRequest(
        String nome,
        String descricao,
        String tecnologia,
        String urlRepositorio,
        String urlDemo
) {
}