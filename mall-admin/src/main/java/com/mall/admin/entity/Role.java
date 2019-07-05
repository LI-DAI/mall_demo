/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.entity;

import com.mall.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lidai
 * @date 2019/7/5 13:57
 * @since
 */
@Data
@Entity
@Table(name = "sys_role")
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1329231498913534153L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 状态，0：正常，1：不可用
     */
    private char status;

    /**
     * 备注
     */
    private String remark;
}

