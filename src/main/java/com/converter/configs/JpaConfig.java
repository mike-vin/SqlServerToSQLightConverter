package com.converter.configs;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        transactionManagerRef = "jpaTransactionManager",
        basePackages = {"com.converter.persistence.repository"})
@EnableTransactionManagement
public class JpaConfig {
    @Value("${spring.jpa.database-platform}")
    private String vendorDatabase;
    @Value("${spring.jpa.hibernate.dialect}")
    private String platformDialect;
    @Value("${spring.jpa.show-sql}")
    private Boolean showSql;
    @Value("${spring.jpa.generate-ddl}")
    private Boolean generateDdl;

    @Value("${spring.datasource.url}")
    private String databaseUrl;
    @Value("${spring.datasource.name}")
    private String databaseNme;
    @Value("${spring.datasource.username}")
    private String databaseUser;
    @Value("${spring.datasource.password}")
    private String databasePassword;
    @Value("${spring.datasource.driver-class-name}")
    private String databaseDriver;
    @Value("${spring.datasource.instance}")
    private String databaseInstance;


    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(getDataSource());
        emf.setJpaVendorAdapter(getJpaVendorAdapter());
        emf.setPersistenceUnitName("com.converter.persistence.repository");
        emf.setPackagesToScan("com.converter.model");
        return emf;
    }


    private JpaVendorAdapter getJpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.valueOf(vendorDatabase));
        vendorAdapter.setShowSql(showSql);
        vendorAdapter.setDatabasePlatform(platformDialect);
        vendorAdapter.setGenerateDdl(generateDdl);
        return vendorAdapter;
    }

    @Bean(name = "jpaTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier(value = "entityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }


    private DataSource getDataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setURL(databaseUrl);
        dataSource.setUser(databaseUser);
        dataSource.setPassword(databasePassword);
        return dataSource;
    }
}
