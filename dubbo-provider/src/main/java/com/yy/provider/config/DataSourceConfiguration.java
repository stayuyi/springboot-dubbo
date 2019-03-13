package com.yy.provider.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * TODO 2019/3/10
 *
 * @author yuyi
 */
@Configuration
public class DataSourceConfiguration {

    @Bean(name = "metisDataSource")
    @Qualifier("metisDataSource")

    @ConfigurationProperties(prefix = "spring.datasource.metis")
    public DataSource pandoraDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "studyDataSource")
    @Qualifier("studyDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.study")
    public DataSource studyDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "pandoraJdbcTemplate")
    public JdbcTemplate pandoraJdbcTemplate(@Qualifier("metisDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name="studyJdbcTemplate")
    public JdbcTemplate studyJdbcTemplate(@Qualifier("studyDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
