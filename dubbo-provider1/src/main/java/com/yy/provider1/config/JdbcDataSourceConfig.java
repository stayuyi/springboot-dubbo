package com.yy.provider1.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;


@Slf4j
@Configuration
public class JdbcDataSourceConfig {

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(false);
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        log.info("========================JpaVendor");
        return adapter;
    }


    @Bean(name = "pandoraDataSource")
    @ConfigurationProperties(prefix = "primary.datasource")
    public DataSource pandoraDataSource() {
        log.info("========================pandoraDataSource");
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "studyDataSource")
    @ConfigurationProperties(prefix = "secondary.datasource")
    public DataSource studyDataSource() {

        log.info("========================studyDataSource");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "pandoraJdbcTemplate")
    public JdbcTemplate pandoraJdbcTemplate(@Qualifier("pandoraDataSource") DataSource dataSource) {
        log.info("========================pandoraJdbcTemplate");
        return new JdbcTemplate(dataSource);
    }

    @Bean(name="studyJdbcTemplate")
    public JdbcTemplate studyJdbcTemplate(@Qualifier("studyDataSource") DataSource dataSource){
        log.info("========================studyJdbcTemplate");
        return new JdbcTemplate(dataSource);
    }
}
