package com.informed.ExtProject.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages =
        {"com.informed.ExtProject.server",
        "com.informed.ExtProject.controller"})
public class TradingApplicationConfig {
}
