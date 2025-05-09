package com.example.jdbcvsjpa.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "test_data")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Data(String name) {
        this.name = name;
    }

    public static Data of(String name) {
        return new Data(name);
    }
}
