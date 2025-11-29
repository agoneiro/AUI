package com.example.demo.parish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SimplifiedParishRepository extends JpaRepository<SimplifiedParish, UUID> {
}