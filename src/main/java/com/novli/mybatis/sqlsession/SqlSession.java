package com.novli.mybatis.sqlsession;

import com.novli.mybatis.binding.MapperMethod;

import java.sql.SQLException;

public interface SqlSession {

    <T> T selectOne(MapperMethod mapperMethod, String statement) throws SQLException;

}
