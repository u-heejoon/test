package com.octatco.sso.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DatasourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.octatco")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource() {
        final DataSourceProperties props = dataSourceProperties();
        final HikariDataSource datasource = DataSourceBuilder.create()
          .type(HikariDataSource.class)
          .driverClassName(props.getDriverClassName())
          .username(props.getUsername())
          .password(props.getPassword())
          .build();
        datasource.setJdbcUrl(props.getUrl());
        return datasource;
    }

}
