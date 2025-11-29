package com.example.demo.dto;

import java.util.UUID;

public record ParishDto (
        UUID id,
        String name,
        String city
) {}
