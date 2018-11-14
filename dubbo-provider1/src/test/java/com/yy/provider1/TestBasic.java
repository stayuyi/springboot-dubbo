package com.yy.provider1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestBasic {

    private final static Map<String, Map<String, Field>> FIELD_MAP = new HashMap<>();
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        for (Map.Entry<String, Field> entry : FIELD_MAP.get(this.getClass().getName()).entrySet()) {
            try {
                map.put(entry.getKey(), entry.getValue().get(this));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(
                        "Failed to parse value to map with entry " + entry.getKey(), e);
            }
        }
        return map;
    }

    @Test
    public  void testReflection(){


    }




    @Test
    public void test() throws UnsupportedEncodingException {
        String s = "一二三abc";
        byte[] bytes1 = s.getBytes("UTF-8");
        byte[] bytes2 = s.getBytes("GBK");

        System.out.println(Arrays.toString(bytes1));
        System.out.println(Arrays.toString(bytes2));
        System.out.println(new String(bytes1, "UTF-8"));
    }
}
