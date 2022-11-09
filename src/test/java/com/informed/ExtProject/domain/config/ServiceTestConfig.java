package com.informed.ExtProject.domain.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@DataJpaTest
//@Configuration -- can't use with @DataJpaTest
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
