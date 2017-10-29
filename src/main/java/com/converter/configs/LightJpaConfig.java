package com.converter.configs;

import com.converter.Main;
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
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.sqlite.SQLiteDataSource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@Component
@EnableJpaRepositories(
        transactionManagerRef = "lightJpaTransactionManager",
        entityManagerFactoryRef = "lightEntityManagerFactory",
        basePackages = {"com.converter.persistence.light"})
@EnableTransactionManagement
public class LightJpaConfig {
    @Value("${jpa.hibernate.dialect.sqlite}")
    private String dialect;

    @Bean(name = "lightEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(getDataSource());
        emf.setJpaVendorAdapter(getJpaVendorAdapter());
        emf.setPersistenceUnitName("com.converter.persistence.light");
        emf.setPackagesToScan("com.converter.model");
        return emf;
    }

    private JpaVendorAdapter getJpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.DEFAULT);
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabasePlatform(dialect);
        vendorAdapter.setGenerateDdl(true);
      //  vendorAdapter.setPrepareConnection(true);
        return vendorAdapter;
    }

    @Bean(name = "lightJpaTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier(value = "lightEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    private DataSource getDataSource() {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(Main.SQLight_URL);
        return dataSource;
    }
}