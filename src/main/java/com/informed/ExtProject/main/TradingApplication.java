package com.informed.ExtProject.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.informed.ExtProject.config")
public class TradingApplication
{
    public static void main( String[] args ) {


        System.out.println("========================");
        System.out.println(("Starting Spring Boot"));
        System.out.println("========================");

        ConfigurableApplicationContext context = SpringApplication.run(TradingApplication.class, args);

        System.out.println("========================");
        System.out.println("Server ready");
        System.out.println("========================");

        System.out.println("http://localhost:8084/counter-party-address.html");
        System.out.println("http://localhost:8084/counter-party-details.html");
    }
}
