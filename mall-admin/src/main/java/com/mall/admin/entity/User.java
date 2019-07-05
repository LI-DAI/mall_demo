/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.entity;

import com.mall.admin.enums.Gender;
import com.mall.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author lidai
 * @date 2019/7/3 11:10
 * <p>
 * 空参构造器必须存在，否则JPA报错
 */
@Data
@Entity
@Table(name = "sys_user")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -4956838508015963036L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 头像路径
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 声明将枚举类以字符串形式存储
     */
    @Enumerated(EnumType.STRING)
    private Gender gender;

    /**
     * 状态 0：正常 1：锁定
     */
    private char status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 角色集合
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "sys_user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String nickname, String username, String password, String salt, String avatar, String email, String phoneNumber, Gender gender, char status, String remark) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.avatar = avatar;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.status = status;
        this.remark = remark;
    }


}

