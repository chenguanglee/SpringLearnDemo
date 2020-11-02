package com.chenguangli.spring.db;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;

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

    @Override
    public void addSkuInfo(String skuId, String productName) {
        String skuIdPrefix = "SKU20200916";
        DecimalFormat df = new DecimalFormat("00000");
        Random random = new Random();
        for (int i = 10; i < 10000; i++) {
            String skuId1 = skuIdPrefix + df.format(i);
            int j = 3+random.nextInt(20);
            String productName1 = getRandomString(j);
            jdbcOperations.update("INSERT INTO t_sku_info(Fsku_id,Fproduct_name) values (?,?)", skuId1, productName1);
        }
    }

    @Override
    public void addRelation() {
        String skuIdPrefix = "SKU20200916";
        DecimalFormat df = new DecimalFormat("00000");
        for (int i = 500;i <1000;i++){
            String skuId1 = skuIdPrefix + df.format(i);
            jdbcOperations.update("INSERT INTO t_relation_sku_info(Fuid,Fsku_id) values (?,?)",2,skuId1);
        }
    }

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
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

