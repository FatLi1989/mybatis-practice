package com.novli.mybatis.binding;

import com.novli.mybatis.sqlsession.DefaultSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author novLi
 * @date 2020年02月28日 16:43
 */
public class MapperProxy<T> implements InvocationHandler {

    private final DefaultSqlSession sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(DefaultSqlSession defaultSqlSession, Class<T> mapperInterface) {
        this.sqlSession = defaultSqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperMethod mapperMethod = sqlSession.getConfiguration().getMapperRegistry().getKnownMappers()
                .get(method.getDeclaringClass().getName() + "." + method.getName());

        if (null != mapperMethod) {
            return sqlSession.selectOne(mapperMethod, String.valueOf(args[0]));
        }
        return method.invoke(proxy, args);
    }
}
