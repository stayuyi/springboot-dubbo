package com.yy.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yy.api.FirstTestService;

import java.text.SimpleDateFormat;
import java.util.Date;
@Service(version = "${provider1.service.version}")
public class FirstTestServiceImpl implements FirstTestService {

    @Override
    public String sayHello(String name) {
        return String.valueOf(new StringBuilder("hello  ").append(name).append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
    }

    @Override
    public String sayLove(String name) {
        return  "love   "+name+"   时间:"+new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}
