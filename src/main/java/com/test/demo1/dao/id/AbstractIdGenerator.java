package com.test.demo1.dao.id;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.enhanced.TableGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Properties;

/**
 * Id生成器
 *
 * @author chenhu
 * @date 2018-11-02
 */
public abstract class AbstractIdGenerator extends TableGenerator {
    public static final String INIT_VALUE = "1";
    public static final String VALUE_LENGTH = "32";
    private static final String TABLE_NAME = "ss_primary_key";
    private static final String SEGMENT_COLUMN_NAME = "name";
    private static final String VALUE_COLUMN_NAME = "value";
    private static final String SEGMENT_VALUE_LENGTH = "segment_value_length";

    /**
     * name值, eg, PK_ACCT_DETAIL_ID
     */
    protected abstract String segmentValue();

    /**
     * 主键前缀
     */
    protected abstract String prefix();

    protected String dateStr() {
        return new SimpleDateFormat("yyyyMMdd").format(Date.from(Instant.now()));
    }

    protected String initialValue() {
        return INIT_VALUE;
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) {
        params.setProperty(TABLE_PARAM, TABLE_NAME);
        params.setProperty(SEGMENT_COLUMN_PARAM, SEGMENT_COLUMN_NAME);
        params.setProperty(VALUE_COLUMN_PARAM, VALUE_COLUMN_NAME);
        params.setProperty(SEGMENT_VALUE_PARAM, segmentValue());
        params.setProperty(INITIAL_PARAM, initialValue());
        params.setProperty(SEGMENT_VALUE_LENGTH, VALUE_LENGTH);
        super.configure(new IntegerType(), params, serviceRegistry);
    }

    public Serializable generate(SessionImplementor session, Object obj) {
        return prefix() + dateStr() + completeByZero(super.generate(session, obj).toString(), 10);
    }

    /**
     * 用0右补齐
     */
    private String completeByZero(String strBase, int len) {
        if (strBase.length() >= len) {
            return strBase;
        }
        String result = "";
        for (int i = 0; i < len - strBase.length(); i++) {
            result += "0";
        }
        return result + strBase;
    }
}
