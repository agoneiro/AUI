package com.example.demo;

import com.example.demo.dto.PriestCreateUpdateDto;
import com.example.demo.dto.PriestDto;
import com.example.demo.dto.PriestReadListDto;
import com.example.demo.parish.SimplifiedParishDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PriestMapper {
    public PriestMapper() {

    }

    public PriestDto toDto(Priest priest) {
        SimplifiedParishDto parishDto = null;
        if (priest.getParish() != null) {
            parishDto = new SimplifiedParishDto(
                    priest.getParish().getId(),
                    priest.getParish().getName()
            );
        }

        return new PriestDto(
                priest.getId(),
                priest.getName(),
                priest.getAge(),
                parishDto
        );
    }

    public PriestReadListDto toReadListDto(Priest priest) {
        return new PriestReadListDto(
                priest.getId(),
                priest.getName(),
                priest.getAge()
        );
    }

    public Priest toEntity(PriestCreateUpdateDto dto) {
        return new Priest.Builder().id(UUID.randomUUID()).name(dto.name()).age(dto.age()).build();
    }

    public void updateEntity(Priest existingPriest, PriestCreateUpdateDto dto) {
        existingPriest.setName(dto.name());
        existingPriest.setAge(dto.age());
    }
}
