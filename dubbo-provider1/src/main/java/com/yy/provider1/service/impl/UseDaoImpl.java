package com.yy.provider1.service.impl;

import com.yy.provider1.UseDao;
import org.springframework.stereotype.Component;

@Component
public class UseDaoImpl implements UseDao {
    @Override
    public Integer save(String name) {
        return 1;
    }
}
