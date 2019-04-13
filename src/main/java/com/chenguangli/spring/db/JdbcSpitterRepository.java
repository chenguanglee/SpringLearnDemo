package com.chenguangli.spring.db;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private static final String INSERT_SPITTER = "INSERT INTO spitter(user_name,password,full_name,email,create_time,modify_time) values(?, ?, ?, ?, ?, ?)";

    private static final String QUERY_SPITTER = "SELECT * FROM spitter where id = ?";

    private static final String INSERT_NEW = "insert into spitter (user_name,password,full_name) values(:username, :password, :fullname)";

    private JdbcOperations jdbcOperations;

    @Inject
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    @Override
    public void addSpitter(Spitter spitter) {
        jdbcOperations.update(INSERT_SPITTER, spitter.getUserName(), spitter.getPassword(), spitter.getFullName(), spitter.getEmail(), spitter.getCreateTime(), spitter.getModifyTime());
    }

    @Override
    public Spitter findOne(int id) {
        return jdbcOperations.queryForObject(QUERY_SPITTER, new SpitterRowMapper(), id);
    }

    private static final class SpitterRowMapper implements RowMapper<Spitter> {
        @Override
        public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Spitter(resultSet.getInt("id"),
                    resultSet.getString("user_name"),
                    resultSet.getString("password"),
                    resultSet.getString("full_name"),
                    resultSet.getString("email"),
                    resultSet.getDate("create_time"),
                    resultSet.getDate("modify_time"),
                    resultSet.getInt("version"));
        }
    }


    public Spitter findOne2(int id) {
        return jdbcOperations.queryForObject(QUERY_SPITTER, new RowMapper<Spitter>() {
            @Override
            public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Spitter(resultSet.getInt("id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getDate("create_time"),
                        resultSet.getDate("modify_time"),
                        resultSet.getInt("version"));
            }
        }, id);
    }

}

