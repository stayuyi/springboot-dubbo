package com.yy.provider1.service.impl;


import com.yy.provider1.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    @Autowired
    private UseDaoImpl useDao;

    @Override
    public Boolean run(String name) {
        return useDao.save(name)>0;
    }

    @Override
    public String testMethod1() {
        useDao.successSave();
        return "我是testMethod1";
    }

    @Override
    public String testMethod2() {
        return "我是testMethod2";
    }

    @Override
    public String testMethod3() {
        return "我是testMethod3";
    }
}
