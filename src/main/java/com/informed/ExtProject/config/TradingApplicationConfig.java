package com.informed.ExtProject.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages =
        {"com.informed.ExtProject.server",
        "com.informed.ExtProject.controller",
        "com.informed.ExtProject.data"})
public class TradingApplicationConfig {
}
