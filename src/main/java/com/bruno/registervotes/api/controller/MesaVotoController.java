package com.bruno.registervotes.api.controller;

import com.bruno.registervotes.api.dto.request.MesaVotoCreateRequestDTO;
import com.bruno.registervotes.api.dto.request.MesaVotoUpdateRequestDTO;
import com.bruno.registervotes.api.dto.response.MesaVotoResponseDTO;
import com.bruno.registervotes.api.mapper.MesaVotoMapper;
import com.bruno.registervotes.domain.entity.MesaVoto;
import com.bruno.registervotes.domain.service.MesaVotoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Mesa Voto", description = "Mesa voto endpoints")
@RestController
@RequestMapping("/mesaVoto")
public class MesaVotoController {
    @Autowired
    private MesaVotoService mesaVotoService;

    @Autowired
    private MesaVotoMapper mesaVotoMapper;

    @GetMapping
    public ResponseEntity<Page<MesaVotoResponseDTO>> list(Pageable pageable) {
        Page<MesaVoto> mesaVotos = mesaVotoService.findAll((pageable));
        return ResponseEntity.ok(mesaVotos.map(mesaVotoMapper::toResponseDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaVotoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mesaVotoMapper.toResponseDTO(mesaVotoService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<MesaVotoResponseDTO> save(@RequestBody MesaVotoCreateRequestDTO dto) {
        MesaVoto mesaVoto = mesaVotoMapper.entityToCreateRequestDTO(dto);
        return new ResponseEntity<>(mesaVotoMapper.toResponseDTO(mesaVotoService.save(mesaVoto)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MesaVotoResponseDTO> update(@PathVariable Long id, @RequestBody MesaVotoUpdateRequestDTO dto) {
        MesaVoto mesaVoto = mesaVotoMapper.updateRequestDTOToEntity(dto);
        return ResponseEntity.ok(mesaVotoMapper.toResponseDTO(mesaVotoService.update(id, mesaVoto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mesaVotoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
