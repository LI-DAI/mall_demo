/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author lidai
 * @date 2019/7/9 17:18
 * @since
 */
@Data
@Entity
@Table(name = "sys_permission")
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"roles", "children"})
@ToString(exclude = {"roles"})
public class Permission implements Serializable {

    private static final long serialVersionUID = -5344829290304431243L;

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
    @ManyToMany(mappedBy = "permissions")
//    @JoinTable(name = "sys_role_permission"
//            , joinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
//            , inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roles;

    @Transient
    private List<Permission> children;

    public Permission(Integer parentId, String name, String perms, String url, String type, String description) {
        this.parentId = parentId;
        this.name = name;
        this.perms = perms;
        this.url = url;
        this.type = type;
        this.description = description;
    }

}

