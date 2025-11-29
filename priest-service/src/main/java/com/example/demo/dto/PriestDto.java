package com.example.demo.dto;

import com.example.demo.parish.*;

import java.util.UUID;

public record PriestDto (
        UUID id,
        String name,
        Integer age,
        SimplifiedParishDto parish
) {}
