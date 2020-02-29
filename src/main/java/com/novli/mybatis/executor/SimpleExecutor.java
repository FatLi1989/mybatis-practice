package com.novli.mybatis.executor;

import com.novli.mybatis.binding.MapperMethod;
import com.novli.mybatis.sqlsession.Configuration;
import com.novli.mybatis.statement.StatementHandler;

import java.sql.SQLException;

/**
 * @author novLi
 * @date 2020年02月28日 11:08
 */
public class SimpleExecutor implements Executor {

    private Configuration configuration;

    public SimpleExecutor(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T query(MapperMethod method, String param) throws SQLException {
        StatementHandler statementHandler = new StatementHandler(configuration);
        System.out.println("执行查询");
        return statementHandler.query(method, param);
    }
}
