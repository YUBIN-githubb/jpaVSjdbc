package com.example.jdbcvsjpa.jpa;

import com.example.jdbcvsjpa.jpa.entity.Data;
import com.example.jdbcvsjpa.jpa.repository.DataRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class jpaTest {

    @Autowired
    private DataRepository dataRepository;

    @Test
    @DisplayName("JPA save 시간 측정 테스트")
    void save_time() {
        int count = 1000;

        // 단건 저장 시간 측정
        long singleStart = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            dataRepository.save(Data.of("단건_" + i));
        }
        long singleEnd = System.currentTimeMillis();

        System.out.println("단건 save 총 소요 시간: " + (singleEnd - singleStart) + "ms");
    }

    @Test
    @DisplayName("JPA saveAll 시간 측정 테스트")
    void saveAll_time() {
        int count = 1000;

        // saveAll 저장 시간 측정
        List<Data> bulkList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            bulkList.add(Data.of("단건_" + i));
        }

        long bulkStart = System.currentTimeMillis();
        dataRepository.saveAll(bulkList);
        long bulkEnd = System.currentTimeMillis();

        System.out.println("saveAll 총 소요 시간: " + (bulkEnd - bulkStart) + "ms");
    }
}
