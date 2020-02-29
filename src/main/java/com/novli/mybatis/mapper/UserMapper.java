package com.novli.mybatis.mapper;

import com.novli.mybatis.pojo.User;

/**
 * @author novLi
 * @date 2020年02月29日 11:36
 */
public interface UserMapper {

    User selectByPrimaryKey(Integer id);

}
