package com.example.jdbcvsjpa.jdbc;

import com.example.jdbcvsjpa.jpa.entity.Data;
import com.example.jdbcvsjpa.jpa.repository.BulkInsert.BulkInsertDataRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class jdbcTest {

    @Autowired
    private BulkInsertDataRepository bulkInsertDataRepository;;

    @Test
    @DisplayName("jdbcTemplate의 batchUpdate를 이용한 시간 측정 테스트")
    void jdbcTest() {
        int count = 1000;

        List<Data> bulkList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            bulkList.add(Data.of("단건_" + i));
        }

        long bulkStart = System.currentTimeMillis();
        bulkInsertDataRepository.jdbcBulkInsert(bulkList);
        long bulkEnd = System.currentTimeMillis();

        System.out.println("batchUpdate 총 소요 시간: " + (bulkEnd - bulkStart) + "ms");
    }
}
