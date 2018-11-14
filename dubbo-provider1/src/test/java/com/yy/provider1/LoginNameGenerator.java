package com.yy.provider1;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;


public class LoginNameGenerator implements InitializingBean {

    private SecureRandom srnd;

    private String base;

    private AtomicInteger inc=new AtomicInteger();

    @Override
    public void afterPropertiesSet() throws Exception {
        srnd = new SecureRandom(UUID.randomUUID().toString().getBytes());
        nextBase();

        inc = new AtomicInteger(0);
    }

    private void nextBase() {
        base = String.valueOf(srnd.nextInt(1000000));
        while (base.length() < 6) {
            base += "0";
        }
    }

    public String next(String prefix) {
        int idx = inc.incrementAndGet();
        if (idx >= 1000000) {
            synchronized (this) {
                int now = inc.get();
                if (now >= 1000000) {
                    nextBase();
                    inc.set(0);
                }
            }

            idx = inc.incrementAndGet();
        }

        String name = prefix + base + idx;
        int padding = 20 - name.length();
        if (padding > 0) {
            name += RandomStringUtils.random(padding, true, false);
        }

        return name;
    }

}
