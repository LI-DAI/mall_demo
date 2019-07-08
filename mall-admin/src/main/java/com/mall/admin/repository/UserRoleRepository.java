/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.repository;

import com.mall.admin.entity.UserRole;
import com.mall.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lidai
 * @date 2019/7/8 10:06
 * @since
 */
public interface UserRoleRepository extends BaseRepository<UserRole, Integer> {

    @Modifying
    @Transactional
    @Query(value = "delete from UserRole where roleId in (?1)")
    void deleteByRoleIds(List<Integer> roleIds);


    @Modifying
    @Transactional
    @Query(value = "delete from UserRole where userId in (?1)")
    void deleteByUserIds(List<Integer> roleIds);
}

