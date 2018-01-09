package com.converter;

import com.converter.configs.RootConfig;
import com.converter.model.light.LightStartTimeEntity;
import com.converter.model.microsoft.MicrosoftStartTimeEntity;
import com.converter.service.LightService;
import com.converter.service.MicrosoftService;
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


        printStartTime(applicationContext);

        printRoute(applicationContext);

        printStation(applicationContext);


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

    private static void printStartTime(ApplicationContext applicationContext) {
        MicrosoftService microsoftService = applicationContext.getBean(MicrosoftService.class);
        LightService lightService = applicationContext.getBean(LightService.class);

        List<MicrosoftStartTimeEntity> allStartTime = microsoftService.getAllStartTime();

        lightService.saveStartTime(allStartTime);

        List<LightStartTimeEntity> startTime = lightService.getAllStartTime();
        System.out.println("Start Time :: SIZE = " + startTime.size());
        startTime.forEach(System.out::println);
    }

    private static void printRoute(ApplicationContext applicationContext) {

    }

    private static void exit() {
        long time = (new Date().getTime() - timeStart) / 1000;
        System.out.println("\nВремя: " + time + " сек\n");
        JOptionPane.showMessageDialog(null, "Исполнено, мой повелитель!\nВремя: " + time + " сек");
        System.exit(0);
    }

    private static CityType selectDBfromUSER() {
        int city = JOptionPane.showOptionDialog(new JFrame(), "какую базу данных нужно обноаить ?", "Выберите тип БД:",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, CityType.values(), CityType.values()[0]);
        return CityType.values()[city];
    }


    private static void printStation(ApplicationContext applicationContext) {
        MicrosoftService stationService = applicationContext.getBean(MicrosoftService.class);
        LightService lightService = applicationContext.getBean(LightService.class);

        List stations = lightService.saveStations(stationService.getAllStations());

        stations.forEach(System.out::println);
        System.out.printf("\n:: LOCAL  :: stations size %d\n", stations.size());
    }

}