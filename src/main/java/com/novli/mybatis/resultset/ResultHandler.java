package com.novli.mybatis.resultset;

import com.novli.mybatis.binding.MapperMethod;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author novLi
 * @date 2020年02月29日 17:01
 */
public class ResultHandler {

    public <T> T handle(PreparedStatement pstmt, MapperMethod method) throws SQLException {
        Object resultObj = new DefaultObjectFactory().create(method.getType());
        ResultSet rs = pstmt.getResultSet();
        if (rs.next()) {
            int i = 0;
            for (Field field :resultObj.getClass().getDeclaredFields()) {
                setValue(resultObj, field, rs, i);
            }

        }
        return (T) resultObj;
    }

    private void setValue(Object resultObj, Field field, ResultSet rs, int i) {
    }

}
