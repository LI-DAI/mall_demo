/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.service;

import com.mall.admin.entity.Role;

/**
 * @author lidai
 * @date 2019/7/5 14:13
 * @since
 */
public interface RoleService {

    void insertRole(Role role);

    void deleteRole(Integer roleId);
}

