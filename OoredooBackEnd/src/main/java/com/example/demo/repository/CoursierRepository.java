package com.example.demo.repository;

import com.example.demo.entities.Coursier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursierRepository extends JpaRepository<Coursier,String> {
}
