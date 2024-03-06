package com.bruno.registervotes.domain.service;

import com.bruno.registervotes.domain.entity.MesaVoto;
import com.bruno.registervotes.domain.repository.MesaVotoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;

@Service
public class MesaVotoService {
    @Autowired
    private MesaVotoRepository mesaVotoRepository;
    public MesaVoto save(MesaVoto mesaVoto) {
        return mesaVotoRepository.save(mesaVoto);
    }

    public MesaVoto findById(Long id) {
        return mesaVotoRepository.findById(id).orElseThrow(() -> new RuntimeException("Table not found"));
    }

    public Page<MesaVoto> findAll(Pageable pageable) {
        return mesaVotoRepository.findAll(pageable);
    }

    public MesaVoto update(Long id, MesaVoto mesaVoto) {
        MesaVoto savedMesaVoto = findById(id);

        BeanUtils.copyProperties(mesaVoto, savedMesaVoto, "id");

        return mesaVotoRepository.save(savedMesaVoto);
    }

    public void delete(Long id) {
        MesaVoto mesaVoto = findById(id);

        mesaVotoRepository.delete(mesaVoto);
    }
}
