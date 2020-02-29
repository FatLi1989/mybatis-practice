package com.novli.mybatis.sqlsession;

import java.io.IOException;

/**
 * @author novLi
 * @date 2020年02月28日 16:06
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Configuration configuration) throws IOException {

       configuration.loadConfiguration();

       return new SqlSessionFactory();
    }
}
