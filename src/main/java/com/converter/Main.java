package com.converter;

import com.converter.configs.RootConfig;
import com.converter.dto.CityDto;
import com.converter.dto.StationDto;
import com.converter.model.CityEntity;
import com.converter.model.StationEntity;
import com.converter.service.MicrosoftServerService;
import com.converter.service.SQLightService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class Main {
    private static String[] CITY = {"В И Н Н И Ц А", "Х М Е Л Ь Н И Ц К И Й"};
    public static String SQLight_URL = "jdbc:sqlite:%s/%s.db";
    public static String DB_NAME;
    public static String ABSOLUTE_PATH;

    public static void main(String[] args) throws InterruptedException {

        setParams();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);

        long timeStart = new Date().getTime();
        printCities(applicationContext);

        printStation(applicationContext);

        System.out.println((timeStart - new Date().getTime()) / 1000);
        System.exit(0);
    }

    private static void setParams() {
        ABSOLUTE_PATH = System.getProperties().getProperty("user.dir");
        DB_NAME = selectDBfromUSER();
        SQLight_URL = String.format(SQLight_URL, ABSOLUTE_PATH, DB_NAME);

        System.out.println("ABSOLUTE_PATH = " + ABSOLUTE_PATH);
        System.out.println("DB_NAME = " + DB_NAME);
        System.out.println("SQLight_URL = " + SQLight_URL);
    }

    private static String selectDBfromUSER() {
        int city = JOptionPane.showOptionDialog(new JFrame(), "какую базу данных нужно обноаить ?", "Выберите тип БД:",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, CITY, CITY[0]);
        return city == 0 ? "VINNITSA" : "CHMELNITSKY";
    }

    private static void printStation(ApplicationContext applicationContext) {
        MicrosoftServerService stationService = applicationContext.getBean(MicrosoftServerService.class);
        SQLightService sqLightService = applicationContext.getBean(SQLightService.class);

        List<StationEntity> stations = stationService.getAllStationsEntities();
        System.out.printf("\n\n:: SERVER :: stations size = %d\n", stations.size());

        int stationsSize = sqLightService.saveAllStations(stations);
        System.out.printf("\n\n:: LOCAL  :: stations size %d\n", stationsSize);

//        List<StationDto> cityDtoList = sqLightService.getAllStations();
//        System.out.printf("\n\n:: LOCAL  :: stations Size = %d\n", cityDtoList.size());
    }

    private static void printCities(ApplicationContext applicationContext) {
        MicrosoftServerService cityService = applicationContext.getBean(MicrosoftServerService.class);
        SQLightService sqLightService = applicationContext.getBean(SQLightService.class);

        List<CityEntity> allCityEntities = cityService.getAllCityEntities();
        System.out.printf("\n\n:: SERVER :: cities size = %s\n", allCityEntities);

        int citiesSize = sqLightService.saveAllCities(allCityEntities);
        System.out.printf("\n\n:: LOCAL  :: cities size = %d\n", citiesSize);

//        List<CityDto> cityDtoList = sqLightService.getAllCities();
//        System.out.printf("\n\n:: LOCAL  :: city = %s\n", cityDtoList);
    }
}