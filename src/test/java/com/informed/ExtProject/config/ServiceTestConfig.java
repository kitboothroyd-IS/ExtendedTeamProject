package com.informed.ExtProject.config;

import org.glassfish.jersey.internal.util.PropertiesClass;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@DataJpaTest
@PropertySource("classpath:jdbc.test.properties")
@ComponentScan(basePackages = {
  "com.informed.ExtProject.server",
  "com.informed.ExtProject.dao",
  "com.informed.ExtProject.controller",
  "com.informed.ExtProject.test.util"})
@EntityScan(basePackages =
  {"com.informed.ExtProject.domain",
    "com.informed.ExtProject.reference"})
@EnableJpaRepositories(basePackages =
  {"com.informed.ExtProject.repo"})
public class ServiceTestConfig {
}
