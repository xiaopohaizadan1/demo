package com.test.demo1.service;

import com.github.pagehelper.*;
import com.test.demo1.dao.UserEntity;
import com.test.demo1.dao.UserRepository;
import com.test.demo1.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author geweijian
 * @data 2019-02-25
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public void save(UserEntity userEntity) {
        UserEntity save = userRepository.save(userEntity);
    }

    public PageInfo<UserEntity> query(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<UserEntity> userEntities = userMapper.query1();

        System.out.println(userEntities.size());

//        int pageNum = userEntities.getPageNum();
//        int pageSize = userEntities.getPageSize();

        PageInfo<UserEntity> objectPageInfo = new PageInfo(userEntities);

        return objectPageInfo;
















//        RowBounds pageRowBounds = new RowBounds(offset, limit);
//        return  new PageInfo<>(userMapper.query(pageRowBounds));
    }

}
