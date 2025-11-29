package com.example.demo;

import com.example.demo.parish.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {
    private final PriestService priestService;
    private final SimplifiedParishRepository simplifiedParishRepository;

    public DataInitializer(PriestService priestService, SimplifiedParishRepository simplifiedParishRepository) {
        this.priestService = priestService;
        this.simplifiedParishRepository = simplifiedParishRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        UUID idGdansk = UUID.fromString("11111111-1111-1111-1111-111111111111");
        UUID idSopot = UUID.fromString("22222222-2222-2222-2222-222222222222");

        SimplifiedParish sp1 = new SimplifiedParish(idGdansk, "Św. Mikołaja");
        SimplifiedParish sp2 = new SimplifiedParish(idSopot, "Św. Wojciecha");

        simplifiedParishRepository.save(sp1);
        simplifiedParishRepository.save(sp2);

        Priest priest1 = new Priest.Builder().id(UUID.randomUUID()).name("Jan Kowalski").age(50).build();
        priest1.setParish(sp1);

        Priest priest2 = new Priest.Builder().id(UUID.randomUUID()).name("Adam Nowak").age(30).build();
        priest2.setParish(sp2);

        priestService.save(priest1);
        priestService.save(priest2);

        System.out.println("--- [Priest-Service] Załadowano uproszczone parafie i księży ---");
    }
}