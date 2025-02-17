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

    public List<Poltrona> findPoltronasBySessao(Long sessaoId) {
        return poltronaRepository.findBySessaoId(sessaoId);
    }

    public void update(Long id, Poltrona poltrona) {
        Optional<Poltrona> poltronaExistente = poltronaRepository.findById(id);

        if (poltronaExistente.isPresent()) {
            Poltrona poltronaUpdate = poltronaExistente.get();
            poltronaUpdate.setNumero(poltrona.getNumero());
            poltronaUpdate.setStatus(poltrona.getStatus());
            poltronaUpdate.setSessao(poltrona.getSessao());
            poltronaRepository.save(poltronaUpdate);
        }
    }
}
