package com.jcstechnol.cinema.services;

import com.jcstechnol.cinema.entities.Poltrona;
import com.jcstechnol.cinema.repositories.PoltronaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoltronaService {
    @Autowired
    private PoltronaRepository poltronaRepository;

    public List<Poltrona> buscarPorSessao(Long sessaoId) {
        return poltronaRepository.findBySessaoId(sessaoId);
    }

    public void atualizar(Long id, Poltrona poltrona) {
        Optional<Poltrona> poltronaExistente = poltronaRepository.findById(id);

        if (poltronaExistente.isPresent()) {
            Poltrona poltronaParaAtualizar = poltronaExistente.get();
            poltronaParaAtualizar.setNumero(poltrona.getNumero()); // exemplo de como copiar dados
            poltronaParaAtualizar.setStatus(poltrona.getStatus());
            poltronaParaAtualizar.setSessao(poltrona.getSessao());
            poltronaRepository.save(poltronaParaAtualizar);
        } else {
            throw new RuntimeException("Poltrona não encontrada para o id: " + id);
        }
    }
}
