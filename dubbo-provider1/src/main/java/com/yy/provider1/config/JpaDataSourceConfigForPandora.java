package com.yy.provider1.config;

import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * TODO 2019/3/14
 *
 * @author yuyi
 */
@Slf4j
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "pandoraEntityManagerFactory",
        transactionManagerRef = "pandoraTransactionManager", basePackages = {
        "com.yy.provider1.repository"}) // 设置Repository所在位置
public class JpaDataSourceConfigForPandora {


    @Autowired
    private DataSource pandoraDataSource;

    @Autowired
    private JpaProperties jpaProperties;




    @Bean(name = "pandoraEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return pandoraEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Bean(name = "pandoraEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean pandoraEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(pandoraDataSource).properties(getVendorProperties(pandoraDataSource))
                // 设置实体类所在位置
                .packages("com.yy.provider1.model")
                .persistenceUnit("pandoraPersistenceUnit").build();
    }

    private Map<String, Object> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }


    @Bean(name = "pandoraTransactionManager")
    public PlatformTransactionManager pandoraTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(pandoraEntityManagerFactory(builder).getObject());
    }





}
