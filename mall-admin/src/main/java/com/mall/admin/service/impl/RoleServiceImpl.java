/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.service.impl;

import com.mall.admin.entity.Role;
import com.mall.admin.repository.RoleRepository;
import com.mall.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lidai
 * @date 2019/7/5 14:13
 * @since
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void insertRole(Role role) {
        roleRepository.save(role);
    }
}

