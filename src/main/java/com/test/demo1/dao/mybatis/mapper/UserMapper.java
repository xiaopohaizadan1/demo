package com.test.demo1.dao.mybatis.mapper;

import com.test.demo1.dao.UserEntity;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author geweijian
 * @data 2019-02-26
 */
public interface UserMapper {
   List<UserEntity> query(RowBounds rowBounds);

   List<UserEntity> query1();

}
