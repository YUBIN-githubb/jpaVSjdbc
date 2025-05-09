package com.example.jdbcvsjpa.jpa.service;

import com.example.jdbcvsjpa.jpa.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataService {

    private final DataRepository dataRepository;


}
