/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lidai
 * @date 2019/7/9 17:22
 * @since
 */
@Data
@Entity
@Table(name = "sys_role_permission")
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1874484215160015901L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "permission_id")
    private Integer permissionId;
}

