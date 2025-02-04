package com.jcstechnol.cinema.services;

import com.jcstechnol.cinema.dtos.SessaoDTO;
import com.jcstechnol.cinema.entities.Filme;
import com.jcstechnol.cinema.entities.Sessao;
import com.jcstechnol.cinema.repositories.SessaoRepository;
import com.jcstechnol.cinema.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    public void salvarSessao(SessaoDTO sessaoDTO) {
        Optional<Filme> filmeOpt = filmeRepository.findById(sessaoDTO.getFilmeId());
        if (filmeOpt.isPresent()) {
            Sessao sessao = new Sessao();
            sessao.setFilme(filmeOpt.get());
            sessao.setHorario(sessaoDTO.getHorario());
            sessao.setSala(sessaoDTO.getSala());
            sessao.setPrecoIngresso(sessaoDTO.getPrecoIngresso());

            sessaoRepository.save(sessao);
        }
    }

    public Optional<List<Sessao>> listarSessoesPorFilme(Long filmeId) {
        List<Sessao> sessoes = sessaoRepository.findByFilmeId(filmeId);
        return Optional.ofNullable(sessoes.isEmpty() ? null : sessoes);
    }
    public List<Sessao> listarSessoes() {
        return sessaoRepository.findAll();
    }

    public Optional<Sessao> obterSessao(Long id) {
        return sessaoRepository.findById(id);
    }

    public void atualizarSessao(SessaoDTO sessaoDTO) {
        Optional<Sessao> sessaoOpt = sessaoRepository.findById(sessaoDTO.getId());
        if (sessaoOpt.isPresent()) {
            Sessao sessao = sessaoOpt.get();
            sessao.setHorario(sessaoDTO.getHorario());
            sessao.setSala(sessaoDTO.getSala());
            sessao.setPrecoIngresso(sessaoDTO.getPrecoIngresso());

            sessaoRepository.save(sessao);
        }
    }

    public void excluirSessao(Long id) {
        sessaoRepository.deleteById(id);
    }
}
