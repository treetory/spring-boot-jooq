package com.treetory.jooq.model;

import com.treetory.jooq.entity.tables.records.SampleRecord;

import java.math.BigDecimal;

public class SampleModel {

    String model;
    BigDecimal price;

    public SampleModel(SampleRecord sample) {
        this.model = sample.getModel();
        this.price = sample.getPrice();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
