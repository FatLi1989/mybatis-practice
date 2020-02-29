package com.novli.mybatis.sqlsession;

import com.novli.mybatis.binding.MapperMethod;
import com.novli.mybatis.binding.MapperProxy;
import com.novli.mybatis.executor.Executor;

import java.lang.reflect.Proxy;
import java.sql.SQLException;


/**
 * @author novLi
 * @date 2020年02月28日 11:06
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    private Executor executor;

    public Configuration getConfiguration() {
        return configuration;
    }

    DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(MapperMethod mapperMethod, String statement) throws SQLException {
        return executor.query(mapperMethod, statement);
    }

    public <T> T getMapper(Class<T> type) {
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new MapperProxy<>(this, type));
    }
}
