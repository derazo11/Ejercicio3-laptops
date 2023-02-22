package com.example.Ejercicio1.repository;

import com.example.Ejercicio1.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop,Long> {
}
