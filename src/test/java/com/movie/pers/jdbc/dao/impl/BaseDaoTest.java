package com.movie.pers.jdbc.dao.impl;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

/**
 *
 * @author Aloren
 */
public class BaseDaoTest {

    private final String deleteScript = "src/test/resources/movie-db-cleanup.sql";
    private final String fillScript = "src/test/resources/movie-db-fill.sql";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void cleanDB() {
        JdbcTestUtils.executeSqlScript(jdbcTemplate, new FileSystemResource(deleteScript), false);
        JdbcTestUtils.executeSqlScript(jdbcTemplate, new FileSystemResource(fillScript), false);
    }
}
