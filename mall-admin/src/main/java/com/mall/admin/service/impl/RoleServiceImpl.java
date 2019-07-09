/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.service.impl;

import com.mall.admin.entity.Role;
import com.mall.admin.repository.RoleRepository;
import com.mall.admin.repository.UserRoleRepository;
import com.mall.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.util.Arrays;

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

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public void insertRole(Role role) {
        role.setCreateTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleRepository.save(role);
    }

    @Override
    public void deleteRole(Integer roleId) {
        userRoleRepository.deleteByRoleIds(Arrays.asList(roleId));
        roleRepository.deleteById(roleId);
    }

    @Override
    public Page<Role> getRoleList(Integer page, Integer size, String roleName) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Role> roles = roleRepository.findAll((root, query, criteriaBuilder) -> {
            Predicate predicate = null;
            if (StringUtils.hasText(roleName)) {
                predicate = criteriaBuilder.like(root.get("roleName").as(String.class), "%" + roleName + "%");
                return criteriaBuilder.and(predicate);
            }
            return null;
        }, pageable);
        return roles;
    }
}

