package com.example.jdbcvsjpa.jpa.repository.BulkInsert;

import com.example.jdbcvsjpa.jpa.entity.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BulkInsertDataRepository {

    private final JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL =
            """
            INSERT INTO test_data (name)
            VALUES (?)
            """;

    public void jdbcBulkInsert(List<Data> dataList) {
        jdbcTemplate.batchUpdate(INSERT_SQL, dataList, 1000, (ps, data) -> {
            ps.setString(1, data.getName());
        });
    }
}
