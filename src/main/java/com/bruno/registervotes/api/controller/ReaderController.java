package com.bruno.registervotes.api.controller;

import com.bruno.registervotes.api.dto.request.ReaderCreateRequestDTO;
import com.bruno.registervotes.api.dto.request.ReaderUpdateRequestDTO;
import com.bruno.registervotes.api.dto.response.ReaderResponseDTO;
import com.bruno.registervotes.api.mapper.ReaderMapper;
import com.bruno.registervotes.api.mapper.ReaderMapper;
import com.bruno.registervotes.domain.entity.Reader;
import com.bruno.registervotes.domain.entity.Reader;
import com.bruno.registervotes.domain.service.ReaderService;
import com.bruno.registervotes.domain.service.ReaderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Reader", description = "Reader endpoints")
@RestController
@RequestMapping("/reader")
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    @Autowired
    private ReaderMapper readerMapper;

    @GetMapping
    public ResponseEntity<Page<ReaderResponseDTO>> list(Pageable pageable) {
        Page<Reader> reader = readerService.findAll((pageable));
        return ResponseEntity.ok(reader.map(readerMapper::toResponseDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReaderResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(readerMapper.toResponseDTO(readerService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ReaderResponseDTO> save(@RequestBody ReaderCreateRequestDTO dto) {
        Reader reader = readerMapper.entityToCreateRequestDTO(dto);
        return new ResponseEntity<>(readerMapper.toResponseDTO(readerService.save(reader)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReaderResponseDTO> update(@PathVariable Long id, @RequestBody ReaderUpdateRequestDTO dto) {
        Reader reader = readerMapper.updateRequestDTOToEntity(dto);
        return ResponseEntity.ok(readerMapper.toResponseDTO(readerService.update(id, reader)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        readerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
