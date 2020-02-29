package com.novli.mybatis.binding;

import java.util.HashMap;
import java.util.Map;

/**
 * @author novLi
 * @date 2020年02月28日 11:25
 */
public class MapperRegistry {


    private Map<String, MapperMethod> knownMappers = new HashMap<>();


    public Map<String, MapperMethod> getKnownMappers() {
        return knownMappers;
    }

    public void setKnownMappers(Map<String, MapperMethod> knownMappers) {
        this.knownMappers = knownMappers;
    }
}
