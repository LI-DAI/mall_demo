/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author lidai
 * @date 2019/7/9 17:18
 * @since
 */
@Data
@Entity
@Table(name = "sys_permission")
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"role"})
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "parent_id")
    private Integer parentId;

    private String name;

    private String perms;

    private String url;

    private String type;

    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinTable(name = "sys_role_permission"
            , joinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Role role;

    public Permission(Integer parentId, String name, String perms, String url, String type, String description) {
        this.parentId = parentId;
        this.name = name;
        this.perms = perms;
        this.url = url;
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", perms='" + perms + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

