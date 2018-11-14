package com.yy.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yy.api.SecondTestService;
@Service
public class SecondTestServiceImpl implements SecondTestService {
    @Override
    public String say1() {
        return "say1";
    }
}
