package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParishService {
    private final ParishRepository parishRepository;
    private final RestTemplate restTemplate;

    private final String PRIEST_SERVICE_URL = "http://PRIEST-SERVICE/api/events/parishes";
    public ParishService(ParishRepository parishRepository, RestTemplate restTemplate) {
        this.parishRepository = parishRepository;
        this.restTemplate = restTemplate;
    }

    @Transactional(readOnly = true)
    public List<Parish> findAll() {
        return parishRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Parish> findById(UUID id) {
        return parishRepository.findById(id);
    }

    @Transactional
    public Parish save(Parish parish) {
        Parish savedParish = parishRepository.save(parish);

        try {
            record EventBody(UUID id, String name) {}

            restTemplate.put(
                    PRIEST_SERVICE_URL + "/" + savedParish.getId(),
                    new EventBody(savedParish.getId(), savedParish.getName())
            );
        } catch (Exception e) {
            System.err.println("Błąd komunikacji z priest-service: " + e.getMessage());
        }
        return savedParish;
    }

    @Transactional
    public void deleteById(UUID id) {
        parishRepository.deleteById(id);

        try {
            restTemplate.delete(PRIEST_SERVICE_URL + "/" + id);
        } catch (Exception e) {
            System.err.println("Błąd komunikacji z priest-service podczas usuwania: " + e.getMessage());
        }
    }
}
