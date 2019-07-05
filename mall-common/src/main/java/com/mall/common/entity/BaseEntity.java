/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author lidai
 * @date 2019/7/3 11:16
 * <p>
 * 标注 @MappedSuperclass 表示此类下得属性将映射到其子类得数据库字段中，JPA注解
 */
@Data
@MappedSuperclass
public class BaseEntity {

    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    @Column(name = "update_by")
    private String updateBy;
}

