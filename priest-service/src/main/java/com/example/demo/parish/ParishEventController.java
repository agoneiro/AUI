package com.example.demo.parish;

import com.example.demo.*;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/events/parishes")
public class ParishEventController {

    private final PriestService priestService;

    public ParishEventController(PriestService priestService) {
        this.priestService = priestService;
    }

    @PutMapping("/{id}")
    public void onParishCreatedOrUpdated(@PathVariable UUID id, @RequestBody SimplifiedParishDto dto) {
        priestService.saveSimplifiedParish(id, dto.name());
    }

    @DeleteMapping("/{id}")
    public void onParishDeleted(@PathVariable UUID id) {
        priestService.deleteParishAndPriests(id);
    }
}