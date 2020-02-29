package com.novli.mybatis;

import com.novli.mybatis.mapper.UserMapper;
import com.novli.mybatis.pojo.User;
import com.novli.mybatis.sqlsession.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author novLi
 * @date 2020年02月29日 11:42
 */
public class MybatisTest {


    public static void main(String[] args) throws IOException {
        InputStream is = MybatisTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        Configuration configuration = new Configuration();
        configuration.setInputStream(is);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        DefaultSqlSession sqlSession = (DefaultSqlSession) sqlSessionFactory.openSession(configuration);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);

    }
}
