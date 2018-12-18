package com.yy.provider1;

import com.yy.provider1.utils.Untils;
import org.junit.Test;

import java.io.IOException;

public class RequestGetTest {
    @Test
    public void test1() throws IOException {
        Untils.setRequest("http://localhost:8002/api/v1/datasource/template/type","get");
    }
}
