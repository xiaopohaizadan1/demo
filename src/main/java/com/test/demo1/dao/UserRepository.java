package com.test.demo1.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author geweijian
 * @data 2019-02-25
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity,String> {
}
