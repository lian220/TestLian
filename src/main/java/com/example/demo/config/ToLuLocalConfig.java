package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.Properties;

@Configuration
@Profile(value = "local")
public class ToLuLocalConfig {

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.123.100:3306?autoReconnect=true&serverTimezone=UTC");
        dataSource.setUsername("tolu");
        dataSource.setPassword("lian0220");
        dataSource.setConnectionProperties(new Properties() {
            {
                setProperty("spring.datasource.testOnBorrow", "true");
                setProperty("spring.datasource.validationQuery", "SELECT 1");
                setProperty("spring.datasource.testWhileIdle", "true");
                setProperty("spring.datasource.timeBetweenEvictionRunsMillis", "3600000");
            }
        });
        return dataSource;
    }
}
