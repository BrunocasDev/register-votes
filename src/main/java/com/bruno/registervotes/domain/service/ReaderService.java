package com.bruno.registervotes.domain.service;

import com.bruno.registervotes.domain.entity.MesaVoto;
import com.bruno.registervotes.domain.entity.Reader;
import com.bruno.registervotes.domain.repository.ReaderRepository;
import com.bruno.registervotes.domain.repository.ReaderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private MesaVotoService mesaVotoService;

    public Reader save(Reader reader) {
        MesaVoto mesaVoto = mesaVotoService.findById(reader.getMesaVoto().getId());
        reader.setMesaVoto(mesaVoto);
        return readerRepository.save(reader);
    }

    public Reader findById(Long id) {
        return readerRepository.findById(id).orElseThrow(() -> new RuntimeException("Table not found"));
    }

    public Page<Reader> findAll(Pageable pageable) {
        return readerRepository.findAll(pageable);
    }

    public Reader update(Long id, Reader reader) {
        Reader savedReader = findById(id);

        if (reader.getMesaVoto().getId() != null){
            MesaVoto mesaVoto = mesaVotoService.findById(reader.getMesaVoto().getId());
            reader.setMesaVoto(mesaVoto);
        }

        BeanUtils.copyProperties(reader, savedReader, "id");

        return readerRepository.save(savedReader);
    }

    public void delete(Long id) {
        Reader reader = findById(id);

        readerRepository.delete(reader);
    }
}
