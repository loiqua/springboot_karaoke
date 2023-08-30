package com.example.karaokeprog2spring.repository.DAO;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class databaseconfig {
   @Bean
   public static DataSource datakaraokesource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();

      dataSource.setUrl("jdbc:postgresql://localhost:5432/karaoke");
       dataSource.setUsername("postgres");
       dataSource.setPassword("Barth123");
       dataSource.setDriverClassName("org.postgresql.Driver");
       return dataSource;
   }
}

