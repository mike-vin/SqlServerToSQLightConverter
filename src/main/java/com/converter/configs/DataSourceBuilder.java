package com.converter.configs;

import com.converter.CityType;
import com.converter.Main;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@PropertySource("classpath:application.properties")
class DataSourceBuilder {
    private SQLServerDataSource dataSource = new SQLServerDataSource();

    @Value("${datasource.vin.url}")
    private String vinUrl;
    @Value("${datasource.vin.username}")
    private String vinUser;
    @Value("${datasource.vin.password}")
    private String vinPassword;

    @Value("${datasource.chmel.url}")
    private String chmelUrl;
    @Value("${datasource.chmel.username}")
    private String chmelUser;
    @Value("${datasource.chmel.password}")
    private String chmelPassword;

    @Value("${datasource.zt.url}")
    private String ztUrl;
    @Value("${datasource.zt.username}")
    private String ztUser;
    @Value("${datasource.zt.password}")
    private String ztPassword;

    @Value("${datasource.chmel.db.name}")
    private String chmelDbName;

    private String customUrl = Main.DB_URL;
    private String customUser = Main.DB_USER;
    private String customPassword = Main.DB_PASSWORD;

    private CityType cityType = Main.CITY_TYPE;


    private DataSource getVinDataSource() {
        dataSource.setURL(vinUrl);
        dataSource.setUser(vinUser);
        dataSource.setPassword(vinPassword);
        System.out.println("VINNITSA DataSource created");
        return dataSource;
    }

    private DataSource getChmelDataSource() {
        dataSource.setURL(chmelUrl);
        dataSource.setUser(chmelUser);
        dataSource.setPassword(chmelPassword);
        System.out.println("Description: " + dataSource.getDescription());
        System.out.println("DatabaseName: " + dataSource.getDatabaseName());
        System.out.println(cityType + " DataSource created");
        return dataSource;
    }

    private DataSource getZtDataSource() {
        dataSource.setURL(ztUrl);
        dataSource.setUser(ztUser);
        dataSource.setPassword(ztPassword);
        System.out.println(cityType + " DataSource created");
        return dataSource;
    }

    private DataSource getCustomDataSource() {
        dataSource.setURL(customUrl);
        dataSource.setUser(customUser);
        dataSource.setPassword(customPassword);
        System.out.println(cityType + " DataSource created");
        return dataSource;
    }

    DataSource getDataSource() {
        System.out.println("SQ_LIGHT:");
        switch (cityType) {
            case VINNITSA:
                return getVinDataSource();
            case CHMELNITSKY:
                return getChmelDataSource();
            case JITOMIR:
                return getZtDataSource();
            default:
                return getCustomDataSource();
        }
    }
}