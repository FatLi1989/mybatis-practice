package com.novli.mybatis.statement;

import ch.qos.logback.core.db.dialect.DBUtil;
import com.novli.mybatis.binding.MapperMethod;
import com.novli.mybatis.resultset.ResultHandler;
import com.novli.mybatis.sqlsession.Configuration;
import com.novli.mybatis.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author novLi
 * @date 2020年02月29日 13:42
 */
public class StatementHandler {

    private Configuration configuration;

    private ResultHandler resultHandler;

    public StatementHandler(Configuration configuration) {
        this.configuration = configuration;
    }

    public <T> T query(MapperMethod method, Object param) throws SQLException {
        Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection
                .prepareStatement(String.format(method.getSql(), Integer.parseInt((String) param)));

        preparedStatement.execute();


        return resultHandler.handle(preparedStatement, method);
    }
}
