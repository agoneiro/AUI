package com.example.demo;

import com.example.demo.parish.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PriestService {

    private final PriestRepository priestRepository;
    private final SimplifiedParishRepository simplifiedParishRepository; // Nowe repozytorium

    public PriestService(PriestRepository priestRepository, SimplifiedParishRepository simplifiedParishRepository) {
        this.priestRepository = priestRepository;
        this.simplifiedParishRepository = simplifiedParishRepository;
    }

    @Transactional(readOnly = true)
    public List<Priest> findAll() {
        return priestRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Priest> findById(UUID id) {
        return priestRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<SimplifiedParish> findParishById(UUID id) {
        return simplifiedParishRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Priest> findByParish(SimplifiedParish parish) {
        return priestRepository.findByParish(parish);
    }

    @Transactional
    public Priest save(Priest priest) {
        return priestRepository.save(priest);
    }

    @Transactional
    public void deleteById(UUID id) {
        priestRepository.deleteById(id);
    }

    @Transactional
    public void deleteParishAndPriests(UUID parishId) {
        SimplifiedParish parish = simplifiedParishRepository.findById(parishId).orElse(null);

        if (parish != null) {
            List<Priest> priests = priestRepository.findByParish(parish);
            priestRepository.deleteAll(priests);
            simplifiedParishRepository.delete(parish);
        }
    }

    @Transactional
    public void saveSimplifiedParish(UUID id, String name) {
        SimplifiedParish parish = new SimplifiedParish(id, name);
        simplifiedParishRepository.save(parish);
    }
}