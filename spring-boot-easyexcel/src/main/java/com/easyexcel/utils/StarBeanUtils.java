package com.easyexcel.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StarBeanUtils {
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("Create class error, please check Construction method!");
        }
    }

    public static <T> T copySingle(Object sourceClazz, Class<T> targetClazz) {
        if (sourceClazz == null) {
            return null;
        }
        T t = newInstance(targetClazz);
        org.springframework.beans.BeanUtils.copyProperties(sourceClazz, t);
        return t;
    }

    public static <T> List<T> copyList(List<?> sourceClazz, Class<T> targetClazz) {
        if (sourceClazz == null) {
            return new ArrayList<>();
        }
        return toDTO(new ArrayList<>(sourceClazz), targetClazz);
    }

    public static <T> List<T> toDTO(List<?> sourceClazz, Class<T> targetClazz) {
        if (sourceClazz == null) {
            return new ArrayList<>();
        }
        List<T> dtoList = new ArrayList<>();
        for (Object v : sourceClazz) {
            dtoList.add(copySingle(v, targetClazz));
        }
        return dtoList;
    }
}
