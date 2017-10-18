package com.converter.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.converter")
@PropertySource("classpath:application.properties")
public class RootConfig {
}
