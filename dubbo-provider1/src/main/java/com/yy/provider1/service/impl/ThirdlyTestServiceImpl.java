package com.yy.provider1.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.uu.api.ThirdlyTestService;

import java.util.Date;
@Service(version = "${provider123.service.version}")
public class ThirdlyTestServiceImpl implements ThirdlyTestService {
    @Override
    public String sayThree(String name) {
        return "sayThree    "+name+"   时间:   "+new Date();
    }
}
