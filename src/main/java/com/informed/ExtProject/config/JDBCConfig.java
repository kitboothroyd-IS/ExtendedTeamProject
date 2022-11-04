package com.informed.ExtProject.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.informed.ExtProject.dao"})
@EntityScan(basePackages = {"com.informed.ExtProject.domain"})
@EnableJpaRepositories(basePackages = {"com.informed.ExtProject.repo"})
public class JDBCConfig {

}


