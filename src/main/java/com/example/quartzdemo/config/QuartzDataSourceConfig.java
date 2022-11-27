package com.example.quartzdemo.config;

import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class QuartzDataSourceConfig {

    @Bean
    @QuartzDataSource
    public DataSource quartzDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/quartz?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        return dataSource;
    }
}
