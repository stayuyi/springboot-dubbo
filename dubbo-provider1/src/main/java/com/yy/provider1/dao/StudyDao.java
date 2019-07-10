package com.yy.provider1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * TODO 2019/3/14
 *
 * @author yuyi
 */
@Repository
public class StudyDao {

    @Autowired
    @Qualifier("studyJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<Map<String,Object>> getPersonInfoAll(){
        String sql="select * from study.person_info";
        return jdbcTemplate.queryForList(sql);
    }

}
