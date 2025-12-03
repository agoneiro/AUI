package com.example.demo;

import com.example.demo.dto.PriestCreateUpdateDto;
import com.example.demo.dto.PriestDto;
import com.example.demo.dto.PriestReadListDto;
import com.example.demo.parish.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class PriestController {
    private static final Logger log = LoggerFactory.getLogger(PriestController.class);
    private final PriestService priestService;
    private final PriestMapper priestMapper;

    public PriestController(PriestService priestService, PriestMapper priestMapper) {
        this.priestService = priestService;
        this.priestMapper = priestMapper;
    }

    @GetMapping("/priests")
    public List<PriestReadListDto> getAllPriests() {
        log.info("--- Zapytanie obsłużone przez instancję PRIEST-SERVICE ---");
        return priestService.findAll().stream()
                .map(priestMapper::toReadListDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/parishes/{parishId}/priests")
    public List<PriestReadListDto> getPriestsByParish(@PathVariable UUID parishId) {
        SimplifiedParish parish = priestService.findParishById(parishId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parish not found (in simplified DB) with ID: " + parishId));

        List<Priest> priests = priestService.findByParish(parish);

        return priests.stream()
                .map(priestMapper::toReadListDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/priests/{id}")
    public PriestDto getPriestById(@PathVariable UUID id) {
        return priestService.findById(id)
                .map(priestMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Priest not found with ID: " + id));
    }

    @PostMapping("/parishes/{parishId}/priests")
    @ResponseStatus(HttpStatus.CREATED)
    public PriestDto createPriest(@PathVariable UUID parishId, @Valid @RequestBody PriestCreateUpdateDto priestDto) {
        SimplifiedParish parish = priestService.findParishById(parishId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot add element to non-existing category (Parish ID: " + parishId + ")"));

        Priest newPriest = priestMapper.toEntity(priestDto);
        newPriest.setId(UUID.randomUUID());

        newPriest.setParish(parish);

        Priest savedPriest = priestService.save(newPriest);
        return priestMapper.toDto(savedPriest);
    }

    @PutMapping("/priests/{id}")
    public PriestDto updatePriest(@PathVariable UUID id, @Valid @RequestBody PriestCreateUpdateDto priestDto) {
        Priest existingPriest = priestService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Priest not found with ID: " + id));

        priestMapper.updateEntity(existingPriest, priestDto);

        Priest updatedPriest = priestService.save(existingPriest);
        return priestMapper.toDto(updatedPriest);
    }

    @DeleteMapping("/priests/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePriest(@PathVariable UUID id) {
        if (priestService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Priest not found with ID: " + id);
        }

        priestService.deleteById(id);
    }
}