/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mall.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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
@EqualsAndHashCode(exclude = {"users"})
public class Role extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1329231498913534153L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 角色名
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 状态，0：正常，1：不可用
     */
    private char status;

    /**
     * 备注
     */
    private String remark;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users;

}

