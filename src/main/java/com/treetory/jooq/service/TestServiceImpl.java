package com.treetory.jooq.service;

import com.treetory.jooq.model.SampleModel;
import com.treetory.jooq.repository.JooqRepository;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    private final JooqRepository jooqRepository;

    public TestServiceImpl(JooqRepository jooqRepository) {
        this.jooqRepository = jooqRepository;
    }

    @Override
    public SampleModel getTest(String modelName) {
        return new SampleModel(jooqRepository.getSample(modelName));
    }
}
