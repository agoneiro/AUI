package com.example.demo.dto;

import java.util.UUID;

public record ParishReadListDto (
        UUID id,
        String name,
        String city
) {}
