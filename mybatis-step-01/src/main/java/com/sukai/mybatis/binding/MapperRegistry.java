package com.sukai.mybatis.binding;

import com.sukai.mybatis.session.SqlSession;
import org.openjdk.jmh.runner.RunnerException;

import java.util.HashMap;
import java.util.Map;

public class MapperRegistry {

    /**
     * 存储代理器工厂容器
     */
    private final Map<Class<?>,MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) throws RunnerException {
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new RunnerException("Type " + type + " is not known to the MapperRegistry .");
        }
        try{
//            return mapperProxyFactory.newInstance();
        }catch (Exception e){
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
        return null;
    }
}
