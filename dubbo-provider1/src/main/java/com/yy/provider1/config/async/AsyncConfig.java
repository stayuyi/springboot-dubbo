package com.yy.provider1.config.async;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * TODO 2019/4/1
 *
 * @author yuyi
 */
@Configuration
@ComponentScan("com.yy.provider1.config.async")
@EnableAsync
public class AsyncConfig {
}
