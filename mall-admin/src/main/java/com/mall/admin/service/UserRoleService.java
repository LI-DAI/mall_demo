/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.service;

import com.mall.admin.entity.UserRole;

import java.util.List;

/**
 * @author lidai
 * @date 2019/7/8 10:15
 * @since
 */
public interface UserRoleService {

    void batchInsert(List<UserRole> userRoles);
}

