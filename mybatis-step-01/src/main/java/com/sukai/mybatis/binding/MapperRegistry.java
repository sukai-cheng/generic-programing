package com.sukai.mybatis.binding;

import java.util.HashMap;
import java.util.Map;

public class MapperRegistry {

    /**
     * 存储代理器工厂容器
     */
    private final Map<Class<?>,MapperProxyFactory<?>> knownMappers = new HashMap<>();


}
