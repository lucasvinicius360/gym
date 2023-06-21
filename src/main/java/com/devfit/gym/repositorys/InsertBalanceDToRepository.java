package com.devfit.gym.repositorys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.devfit.gym.dto.InsertBalanceDTO;

@Repository
public class InsertBalanceDToRepository implements RowMapper {

    private final JdbcTemplate jdbcTemplate;

    public InsertBalanceDToRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // rodando a query nativa no spring
    public void insertBalance(Integer user_id, Integer dt_pay) {

        String sql = "insert into balence_gym (user_id,dt_pay,vl_pay) values(?,sysdate(),?)";
        jdbcTemplate.update(sql, user_id, dt_pay);

    }

    public Object getInsertPay(Integer user_id){

        Object result = new Object();
        String sql = "select user_id from balence_gym where user_id = " + user_id;
        result = jdbcTemplate.queryForObject(sql, Long.class);

        return result;


        

    }

    @Override
    public InsertBalanceDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        InsertBalanceDTO gBalanceDTO = new InsertBalanceDTO();

        gBalanceDTO.setIdBalance(rs.getLong("id_balence"));
        gBalanceDTO.setUserId(rs.getInt("user_id"));
        gBalanceDTO.setDtPay(rs.getDate("dt_pay"));
        gBalanceDTO.setVlPay(rs.getInt("vl_pay"));

        return gBalanceDTO;

    }

    // public List<InsertBalanceDTO> consultarObjetos() {
    // String sql = "SELECT id, nome FROM sua_tabela";
    // return jdbcTemplate.query(sql, new SeuObjetoRowMapper());
    // }

}
