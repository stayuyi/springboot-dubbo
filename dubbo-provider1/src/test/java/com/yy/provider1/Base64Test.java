package com.yy.provider1;

import com.yy.provider1.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
@Slf4j
public class Base64Test {
    @Test
    public void test1(){
        String s = null;
        try {
            s = new String(Base64.getDecoder().decode("MTIzNDU2Nzg5MDEyMzQ1Ng=="), "UTF-8");
        } catch (UnsupportedEncodingException e) {

        }
       log.info(s);
    }

    @Test
    public void test2() throws UnsupportedEncodingException {
        String s="\u793E\u4FDD";

        System.out.println(new String(s.getBytes("UTF-8"),"UTF-8"));

    }
    @Test
    public void test3(){
        User user = new User();

    }


}
