package com.test.demo1.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author geweijian
 * @data 2019-02-25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "hn_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(generator = "UserIdGenerator")
//    @GenericGenerator(name = "UserIdGenerator", strategy = "com.test.demo1.dao.id.UserIdGenerator")
    private long id;

    @Column
    private String name;
}
