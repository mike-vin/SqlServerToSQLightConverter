package com.converter.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
        transactionManagerRef = "jpaTransactionManager",
        basePackages = {"com.converter.persistence.microsoft"})
@EnableTransactionManagement
public class MicrosoftJpaConfig {
    private final DataSourceBuilder dataSourceBuilder;
    @Value("${jpa.database-platform}")
    private String vendorDatabase;
    @Value("${jpa.show-sql}")
    private Boolean showSql;
    @Value("${jpa.hibernate.dialect.microsoft}")
    private String platformDialect;
    @Value("${jpa.generate-ddl}")
    private Boolean generateDdl;

    @Autowired
    public MicrosoftJpaConfig(DataSourceBuilder dataSourceBuilder) {
        this.dataSourceBuilder = dataSourceBuilder;
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSourceBuilder.getDataSource());
        emf.setJpaVendorAdapter(getJpaVendorAdapter());
        emf.setPersistenceUnitName("com.converter.persistence.microsoft");
        emf.setPackagesToScan("com.converter.model");
        return emf;
    }

    private JpaVendorAdapter getJpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.valueOf(vendorDatabase));
        // vendorAdapter.setShowSql(showSql);
        vendorAdapter.setDatabasePlatform(platformDialect);
        vendorAdapter.setGenerateDdl(generateDdl);
        return vendorAdapter;
    }

    @Primary
    @Bean(name = "jpaTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier(value = "entityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}