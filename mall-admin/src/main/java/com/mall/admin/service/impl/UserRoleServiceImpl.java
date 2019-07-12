/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.service.impl;

import com.mall.admin.entity.UserRole;
import com.mall.admin.repository.UserRoleRepository;
import com.mall.admin.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lidai
 * @date 2019/7/8 10:16
 * @since
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    /**
     * 批量新增
     *
     * @param userRoles
     */
    @Override
    public void batchInsert(List<UserRole> userRoles) {
        userRoleRepository.saveAll(userRoles);
    }
}

