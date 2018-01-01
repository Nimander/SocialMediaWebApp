package com.wordpress.nimanderdev.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.wordpress.nimanderdev.web", "com.wordpress.nimanderdev.repo", "com.wordpress.nimanderdev.config"}, excludeFilters={@Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class)})
public class RootConfig {
}
