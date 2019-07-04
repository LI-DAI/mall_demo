/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.entity;

import com.mall.admin.enums.Gender;
import com.mall.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lidai
 * @date 2019/7/3 11:10
 * <p>
 * 空参构造器必须存在，否则JPA报错
 */
@Data
@Entity
@Table(name = "sys_user")
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -4956838508015963036L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}

