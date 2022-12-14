package com.informed.ExtProject.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan(basePackages = {"com.informed.ExtProject.dao"})
@EntityScan(basePackages = {"com.informed.ExtProject.domain", "com.informed.ExtProject.reference"})
@EnableJpaRepositories(basePackages = {"com.informed.ExtProject.repo"})
public class JDBCConfig {

}


