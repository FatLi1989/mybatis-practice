package com.novli.mybatis.executor;

import com.novli.mybatis.binding.MapperMethod;

import java.sql.SQLException;

public interface Executor {
    <T> T query(MapperMethod method, String param) throws SQLException;
}
