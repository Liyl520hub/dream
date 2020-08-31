package com.dream.cleaner.beans;

import java.io.Serializable;

/**
 * @author : Liyalei
 * date   : 2020/9/1
 * desc   :
 */
public class PlanBean implements Serializable {

    private String name;

    public PlanBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }
}
