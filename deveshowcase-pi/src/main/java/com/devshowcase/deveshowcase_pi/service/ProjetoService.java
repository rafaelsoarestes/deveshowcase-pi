package com.devshowcase.deveshowcase_pi.service;

import com.devshowcase.deveshowcase_pi.dto.ProjetoRequest;
import com.devshowcase.deveshowcase_pi.model.Projeto;
import com.devshowcase.deveshowcase_pi.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository repository;

    public ProjetoService(ProjetoRepository repository) {
        this.repository = repository;
    }

    public List<Projeto> listar() {
        return repository.findAll();
    }

    public Projeto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Projeto não encontrado"));
    }

    public Projeto salvar(ProjetoRequest dados) {
        Projeto projeto = new Projeto(
                dados.nome(),
                dados.descricao(),
                dados.tecnologia(),
                dados.urlRepositorio(),
                dados.urlDemo()
        );

        return repository.save(projeto);
    }

    public Projeto atualizar(Long id, ProjetoRequest dados) {
        Projeto projeto = buscarPorId(id);

        projeto.setNome(dados.nome());
        projeto.setDescricao(dados.descricao());
        projeto.setTecnologia(dados.tecnologia());
        projeto.setUrlRepositorio(dados.urlRepositorio());
        projeto.setUrlDemo(dados.urlDemo());

        return repository.save(projeto);
    }

    public void excluir(Long id) {
        Projeto projeto = buscarPorId(id);
        repository.delete(projeto);
    }
}
