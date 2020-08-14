/*
 * This file is generated by jOOQ.
 */
package com.treetory.jooq.entity.tables.records;


import com.treetory.jooq.entity.tables.Sample;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SampleRecord extends UpdatableRecordImpl<SampleRecord> implements Record3<Integer, String, BigDecimal> {

    private static final long serialVersionUID = -1845076199;

    /**
     * Setter for <code>test.SAMPLE.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>test.SAMPLE.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>test.SAMPLE.model</code>.
     */
    public void setModel(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>test.SAMPLE.model</code>.
     */
    public String getModel() {
        return (String) get(1);
    }

    /**
     * Setter for <code>test.SAMPLE.price</code>.
     */
    public void setPrice(BigDecimal value) {
        set(2, value);
    }

    /**
     * Getter for <code>test.SAMPLE.price</code>.
     */
    public BigDecimal getPrice() {
        return (BigDecimal) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, BigDecimal> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, BigDecimal> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Sample.SAMPLE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Sample.SAMPLE.MODEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field3() {
        return Sample.SAMPLE.PRICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getModel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component3() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getModel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value3() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SampleRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SampleRecord value2(String value) {
        setModel(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SampleRecord value3(BigDecimal value) {
        setPrice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SampleRecord values(Integer value1, String value2, BigDecimal value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SampleRecord
     */
    public SampleRecord() {
        super(Sample.SAMPLE);
    }

    /**
     * Create a detached, initialised SampleRecord
     */
    public SampleRecord(Integer id, String model, BigDecimal price) {
        super(Sample.SAMPLE);

        set(0, id);
        set(1, model);
        set(2, price);
    }
}
