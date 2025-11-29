package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ParishService parishService;

    public DataInitializer(ParishService parishService) {
        this.parishService = parishService;
    }

    @Override
    public void run(String... args) throws Exception {
        UUID idGdansk = UUID.fromString("11111111-1111-1111-1111-111111111111");
        UUID idSopot = UUID.fromString("22222222-2222-2222-2222-222222222222");

        Parish p1 = new Parish.Builder().id(idGdansk).name("Św. Mikołaja").city("Gdańsk").build();
        Parish p2 = new Parish.Builder().id(idSopot).name("Św. Wojciecha").city("Sopot").build();

        parishService.save(p1);
        parishService.save(p2);

        System.out.println("--- [Parish-Service] Załadowano parafie ---");
    }
}
