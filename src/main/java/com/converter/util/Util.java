package com.converter.util;

import com.converter.dto.CityDto;
import com.converter.model.CityEntity;
import org.slf4j.Logger;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Util {

    public static boolean isNullOrEmptyList(List list) {
        return isNull(list) || list.isEmpty();
    }

    public static boolean notEmpty(List list) {
        return nonNull(list) && !list.isEmpty();
    }

    public static <T> List<T> getEmptyIfNull(List<T> list) {
        return isNull(list) ? Collections.emptyList() : list;
    }

    public static boolean isEmpty(List result) {
        return !notEmpty(result);
    }


    public static <T, R> List<R> toDTOList(List<T> entities, Comparator<T> comparator, Function<T, R> function) {
        if (isNullOrEmptyList(entities)) {
            return Collections.emptyList();
        }
        if (isNull(comparator)) {
            return entities.stream().map(function).collect(Collectors.toList());
        }
        return entities.stream().sorted(comparator).map(function).collect(Collectors.toList());
    }

    public static <T, R> List<R> toDTOList(List<T> entities, Comparator<T> comparator, Function<T, R> function, Logger logger, String message) {
        if (isNullOrEmptyList(entities)) {
            logger.info(message);
            return Collections.emptyList();
        }
        if (isNull(comparator)) {
            return entities.stream().map(function).collect(Collectors.toList());
        }
        return entities.stream().sorted(comparator).map(function).collect(Collectors.toList());
    }

    public static <T> List<T> toList(T entity) {
        List<T> list = new ArrayList<>();
        if (nonNull(entity)) {
            list.add(entity);
        }
        return list;
    }

    public static <R, T> R toDTO(T entity, Function<T, R> function) {
        if (nonNull(entity)) {
            return function.apply(entity);
        }
        JOptionPane.showMessageDialog(null, "NO SUCH ELEMENT !");
        System.exit(0);
        throw new RuntimeException("NO SUCH ELEMENT !");
    }
}
