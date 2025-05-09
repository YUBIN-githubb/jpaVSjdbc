package com.example.jdbcvsjpa.jpa.repository;

import com.example.jdbcvsjpa.jpa.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {
}
