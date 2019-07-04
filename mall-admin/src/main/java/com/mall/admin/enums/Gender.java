/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.enums;

/**
 * @author lidai
 * @date 2019/7/3 11:34
 * @since
 */
public enum Gender {

    MALE("MALE"), FEMALE("FEMALE");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
