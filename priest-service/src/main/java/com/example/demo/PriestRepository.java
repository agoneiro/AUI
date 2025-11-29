package com.example.demo;

import com.example.demo.parish.SimplifiedParish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PriestRepository extends JpaRepository<Priest, UUID> {
    List<Priest> findByParish(SimplifiedParish parish);
}
