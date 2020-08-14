package com.treetory.jooq.repository;

import com.treetory.jooq.entity.Test;
import com.treetory.jooq.entity.tables.records.SampleRecord;
import org.jooq.DSLContext;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class JooqRepository {

    private final DSLContext dslContext;
    /**
     * Configure the DSL object, optionally overriding jOOQ Exceptions with Spring Exceptions
     *
     * jOOQ 는 DSL (Domain Specific Language) 을 통해 SQL 을 다룬다. 그래서 DSLContext 를 기본적으로 필요로 한다.
     * DSLContext 를 생성할 때에 jOOQ 의 configuration 을 전달해야 하는데,
     * 아래는 connectionProvider 와 ExecuteListenerProvider 를 설정한 configuration 을 DSLContext 에 전달한다.
     *
     * @return
     */
    public JooqRepository(DefaultConfiguration jooqConfiguration) {
        this.dslContext = new DefaultDSLContext(jooqConfiguration);
    }

    public SampleRecord getSample(String modelName) {
        SampleRecord sampleRecord = dslContext
                .selectFrom(Test.TEST.SAMPLE)
                .where(Test.TEST.SAMPLE.MODEL.eq(modelName))
                .fetchAny();
        return sampleRecord;
    }

}
