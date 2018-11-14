package com.yy.provider1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


public class TestLoginNameGenrator {
    LoginNameGenerator generator=new LoginNameGenerator();

@Test
    public void test(){
        String name="abc";
        String prefix="prEfix";

        String next = generator.next(prefix.toLowerCase());
        System.out.println("--------------------------------------"+next);

    }
}
