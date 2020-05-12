package com.test.demo1.dao.id;


/**
 * @author chenhu
 * @date 2018-11-02
 */
public class UserIdGenerator extends AbstractIdGenerator {
    @Override
    protected String segmentValue() {
        return "PK_USER_ID";
    }

    @Override
    protected String prefix() {
        return "G";
    } // 用户

    @Override
    protected String dateStr() {
        return "";
    }
}
