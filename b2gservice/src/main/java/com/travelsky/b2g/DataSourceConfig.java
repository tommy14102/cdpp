package com.travelsky.b2g;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {

    /**
    @Bean(name = "pubDataSource")
    @Qualifier("pubDataSource")
    @ConfigurationProperties(prefix="spring.datasource.pub")
    public DataSource pubDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "localDataSource")
    @Qualifier("localDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.local")
    public DataSource localDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "pubJdbcTemplate")
    public JdbcTemplate pubJdbcTemplate(
            @Qualifier("pubDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "localJdbcTemplate")
    public JdbcTemplate localJdbcTemplate(
            @Qualifier("localDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
            */

}