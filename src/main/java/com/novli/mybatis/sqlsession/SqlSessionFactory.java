package com.novli.mybatis.sqlsession;

import com.novli.mybatis.executor.SimpleExecutor;

/**
 * @author novLi
 * @date 2020年02月28日 15:58
 */
public class SqlSessionFactory {

    public SqlSession openSession(Configuration configuration) {
       return new DefaultSqlSession(configuration, new SimpleExecutor(configuration));
    }
}
