package com.dream.cleaner.beans;


import com.chad.library.adapter.base.entity.JSectionEntity;

/**
 * @author lyl
 * <p>
 * created 2019/6/17
 * <p>
 * class use:
 */
public class PlanSectionBean<T> extends JSectionEntity {

    private boolean isHeader;
    /**
     * 数据内容
     */
    private T t;
    public String header;

    public PlanSectionBean(boolean isHeader, String header) {
        this.isHeader = isHeader;
        this.header = header;
        this.t = null;
    }

    public PlanSectionBean(T t) {
        this.isHeader = false;
        this.header = null;
        this.t = t;
    }

    public T getItem() {
        return t;
    }

    /**
     * 重写此方法，返回 boolen 值，告知是否是header
     */
    @Override
    public boolean isHeader() {
        return isHeader;
    }



}
