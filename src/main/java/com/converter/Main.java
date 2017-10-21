package com.converter;

import com.converter.configs.RootConfig;
import com.converter.dto.CityDto;
import com.converter.model.CityEntity;
import com.converter.model.StationEntity;
import com.converter.service.MicrosoftService;
import com.converter.service.LightService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

public class Main {
    private static long timeStart;
    public static String SQLight_URL = "jdbc:sqlite:%s/%s.db";
    public static String DB_NAME;
    public static String ABSOLUTE_PATH;
    public static String DB_URL; //todo
    public static String DB_USER; //todo
    public static String DB_PASSWORD; //todo
    public static CityType CITY_TYPE;

    public static void main(String[] args) throws InterruptedException {

        setParams();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);

        printCities(applicationContext);

      //  printStation(applicationContext);

        exit();

    }

    private static void setParams() {
        timeStart = new Date().getTime();
        ABSOLUTE_PATH = Paths.get(System.getProperties().getProperty("user.dir")).getParent().toString();
        CITY_TYPE = selectDBfromUSER();
        DB_NAME = CITY_TYPE.toString();
        SQLight_URL = String.format(SQLight_URL, ABSOLUTE_PATH, DB_NAME);
// FIXME:
        DB_URL = "1gb_zt-db";
        DB_USER = "1gb_monp";
        DB_PASSWORD = "b7925a08yu";

        System.out.printf("ABSOLUTE_PATH = %s\nDB_NAME = %s\nSQLight_URL = %s\n", ABSOLUTE_PATH, DB_NAME, SQLight_URL);
    }

    private static void exit() {
        long time = (new Date().getTime() - timeStart) / 1000;
        JOptionPane.showMessageDialog(null, "Исполнено, мой повелитель!\nВремя: " + time + " сек");
        System.exit(0);
    }

    private static CityType selectDBfromUSER() {
        int city = JOptionPane.showOptionDialog(new JFrame(), "какую базу данных нужно обноаить ?", "Выберите тип БД:",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, CityType.values(), CityType.values()[0]);
        return CityType.values()[city];
    }

    private static void printCities(ApplicationContext applicationContext) {
        MicrosoftService microsoftService = applicationContext.getBean(MicrosoftService.class);
        List<CityEntity> allCityEntities = microsoftService.getAllCityEntities();
        LightService lightService = applicationContext.getBean(LightService.class);
        int citiesSize = lightService.saveAllCities(allCityEntities);
        List<CityDto> allCitiesDto = lightService.getAllCities();
        List<CityEntity> allCitiesEntity = lightService.getAllCitiesEntity();

        System.out.printf("\n:: SERVER :: cities = %s", allCityEntities);
        System.out.printf("\n:: LOCAL  :: cities = " + allCitiesEntity);
        System.out.printf("\n:: LOCAL  :: cities = " + allCitiesDto);
    }

    private static void printStation(ApplicationContext applicationContext) {
        MicrosoftService stationService = applicationContext.getBean(MicrosoftService.class);
        LightService lightService = applicationContext.getBean(LightService.class);

        List<StationEntity> stations = stationService.getAllStationsEntities();
        int stationsSize = lightService.saveAllStations(stations);

        //stations.forEach(System.out::println);
        System.out.printf("\n:: SERVER :: stations size = %d\n", stations.size());
        System.out.printf(":: LOCAL  :: stations size %d\n", stationsSize);
    }

}