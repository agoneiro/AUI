package com.example.demo;

import com.example.demo.dto.ParishCreateUpdateDto;
import com.example.demo.dto.ParishDto;
import com.example.demo.dto.ParishReadListDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ParishMapper {
    public ParishMapper() {

    }

    public ParishDto toDto(Parish parish) {
        return new ParishDto(
                parish.getId(),
                parish.getName(),
                parish.getCity()
        );
    }

    public ParishReadListDto toReadListDto(Parish parish) {
        return new ParishReadListDto(
                parish.getId(),
                parish.getName(),
                parish.getCity()
        );
    }

    public Parish toEntity(ParishCreateUpdateDto dto) {
        return new Parish.Builder().id(UUID.randomUUID()).name(dto.name()).city(dto.city()).build();
    }

    public void updateEntity(Parish existingParish, ParishCreateUpdateDto dto) {
        existingParish.setName(dto.name());
        existingParish.setCity(dto.city());
    }
}