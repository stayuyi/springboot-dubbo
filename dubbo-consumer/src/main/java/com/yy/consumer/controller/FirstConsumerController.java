package com.yy.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.uu.api.ThirdlyTestService;
import com.yy.api.FirstTestService;
import com.yy.api.SecondTestService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstConsumerController {

    @Reference(version = "${consumer.service.version}")
    private FirstTestService firstTestService;

    @Reference(version = "${consumer.service.version}")
    private SecondTestService secondTestService;

    @Reference(version = "${consumer.service.version}")
    private ThirdlyTestService thirdlyTestService;

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return firstTestService.sayHello(name);
    }

    @RequestMapping("/sayLove/{name}")
    public String sayLove(@PathVariable("name") String name) {
        return firstTestService.sayLove(name);
    }

    @RequestMapping("/say1")
    public String say1() {
        return secondTestService.say1();
    }

    @RequestMapping("/say3/{name}")
    public String say3(@PathVariable("name") String name) {
        return thirdlyTestService.sayThree(name);
    }

}