package com.yy.provider1.enumtest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by yuyi on 2019/1/25.
 */
@Slf4j
public class TestEnum {

    @Test
    public void test1(){
        //valueOf(String str)   返回一个  此方法返回具有指定名称的枚举类型的枚举常量。
        UnionpayEnums weirenzheng = UnionpayEnums.valueOf("WEIRENZHENG");
        log.info("=====>>>>>>>>>{}",weirenzheng.toString());
        log.info("=====>>>>>>>>>{}",UnionpayEnums.WEIRENZHENG);



        UnionpayEnums[] enums = UnionpayEnums.values();
        int code=3;
        UnionpayEnums first = Arrays.stream(enums).filter(e -> e.getCode() == code).findFirst().get();
        log.info("======>>>>>>{}",first);

    }


}
