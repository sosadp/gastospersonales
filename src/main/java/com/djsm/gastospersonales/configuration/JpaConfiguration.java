package com.djsm.gastospersonales.configuration;


import org.apache.commons.lang3.StringUtils;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.djsm.gastospersonales.repositories",
    entityManagerFactoryRef = "entityManagerFactory",
    transactionManagerRef ="transactionManager")
public class JpaConfiguration {

    @Autowired
    private Environment environment;

    @Value("${datasource.sampleapp.mazPoolSize:10}")
    private int maxPoolSize;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.sampleapp")
    public DataSourceProperties dataSourceProperties(){

        return new DataSourceProperties();
    }

    @Bean
    public DataSource dataSource(){
        DataSourceProperties dataSourceProperties = dataSourceProperties();
           HikariDataSource dataSource = DataSourceBuilder
                   .create(dataSourceProperties.getClassLoader())
                   .driverClassName(dataSourceProperties.getDriverClassName())
                   .url(dataSourceProperties.getUrl())
                   .username(dataSourceProperties.getUsername())
                   .password(dataSourceProperties.getPassword())
                   .type(HikariDataSource.class)
                   .build();
           dataSource.setMaximumPoolSize(maxPoolSize);
           return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factoryBean =new LocalContainerEntityManagerFactoryBean();
            factoryBean.setDataSource(dataSource());
            factoryBean.setPackagesToScan(new String[] {"com.djsm.gastospersonales.model"});
            factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
            factoryBean.setJpaProperties(jpaProperties());
            return factoryBean;

    }


    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        return hibernateJpaVendorAdapter;
    }

    private Properties jpaProperties() {

        Properties properties= new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("datasource.sampleapp.hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto",environment.getRequiredProperty("datasource.sampleapp.hibernate.hbm2ddl.method"));
        properties.put("hibernate.show_sql",environment.getRequiredProperty("datasource.sampleapp.hibernate.show_sql"));
        properties.put("hibernate.format_sql",environment.getRequiredProperty("datasource.sampleapp.hibernate.format_sql"));
        if (StringUtils.isNotEmpty(environment.getProperty("datasource.sampleapp.defaultSchema"))){
            properties.put("hibernate.default_schema",environment.getRequiredProperty("datasource.sampleapp.defaultSchema"));
        }

        return properties;
    }


    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager txManager= new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;

    }



}
