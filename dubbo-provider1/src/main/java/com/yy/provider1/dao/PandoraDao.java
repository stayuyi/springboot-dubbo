package com.yy.provider1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * TODO 2019/3/14
 *
 * @author yuyi
 */

public class PandoraDao {
    @Autowired
    @Qualifier("pandoraJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<Map<String,Object>> queryTaskAll(){
        String sql="select * from task";
        return jdbcTemplate.queryForList(sql);
    }

}
