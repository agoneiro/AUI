package com.example.demo;

import com.example.demo.dto.ParishCreateUpdateDto;
import com.example.demo.dto.ParishDto;
import com.example.demo.dto.ParishReadListDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parishes")
public class ParishController {
    private final ParishService parishService;
    private final ParishMapper parishMapper;

    public ParishController(ParishService parishService, ParishMapper parishMapper) {
        this.parishService = parishService;
        this.parishMapper = parishMapper;
    }

    @GetMapping
    public List<ParishReadListDto> getAllParishes() {
        return parishService.findAll().stream()
                .map(parishMapper::toReadListDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ParishDto getParishById(@PathVariable UUID id) {
        return parishService.findById(id)
                .map(parishMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parish not found with ID: " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParishDto createParish(@Valid @RequestBody ParishCreateUpdateDto parishDto) {
        Parish newParish = parishMapper.toEntity(parishDto);
        newParish.setId(UUID.randomUUID());

        Parish savedParish = parishService.save(newParish);
        return parishMapper.toDto(savedParish);
    }

    @PutMapping("/{id}")
    public ParishDto updateParish(@PathVariable UUID id, @Valid @RequestBody ParishCreateUpdateDto parishDto) {
        Parish existingParish = parishService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parish not found with ID: " + id));

        parishMapper.updateEntity(existingParish, parishDto);

        Parish updatedParish = parishService.save(existingParish);
        return parishMapper.toDto(updatedParish);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParish(@PathVariable UUID id) {
        if (!parishService.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Parish not found with ID: " + id);
        }
        parishService.deleteById(id);
    }
}