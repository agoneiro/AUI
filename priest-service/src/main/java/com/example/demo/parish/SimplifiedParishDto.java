package com.example.demo.parish;
import java.util.UUID;

public record SimplifiedParishDto(
        UUID id,
        String name
) {}