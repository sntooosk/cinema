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

    public void createSessao(SessaoDTO sessaoDTO) {
        Optional<Filme> filmeOpt = filmeRepository.findById(sessaoDTO.getFilmeId());
        if (filmeOpt.isPresent()) {
            Sessao sessao = new Sessao();
            sessao.setFilme(filmeOpt.get());
            sessao.setHorario(sessaoDTO.getHorario());
            sessao.setSala(sessaoDTO.getSala());

            sessaoRepository.save(sessao);
        }
    }

    public Optional<List<Sessao>> getSessaoByFilmeId(Long filmeId) {
        List<Sessao> sessoes = sessaoRepository.findByFilmeId(filmeId);
        return Optional.ofNullable(sessoes.isEmpty() ? null : sessoes);
    }
    public List<Sessao> getAllSessao() {
        return sessaoRepository.findAll();
    }

    public Optional<Sessao> getByIdSessao(Long id) {
        return sessaoRepository.findById(id);
    }

    public void updateSessao(SessaoDTO sessaoDTO) {
        Optional<Sessao> sessaoOpt = sessaoRepository.findById(sessaoDTO.getId());
        if (sessaoOpt.isPresent()) {
            Sessao sessao = sessaoOpt.get();
            sessao.setHorario(sessaoDTO.getHorario());
            sessao.setSala(sessaoDTO.getSala());

            sessaoRepository.save(sessao);
        }
    }

    public void deleteSessao(Long id) {
        sessaoRepository.deleteById(id);
    }
}
