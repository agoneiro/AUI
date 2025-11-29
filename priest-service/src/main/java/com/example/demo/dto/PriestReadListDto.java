package com.example.demo.dto;

import java.util.UUID;

public record PriestReadListDto(
        UUID id,
        String name,
        Integer age
) {}
