/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.repository;

import com.mall.admin.entity.User;
import com.mall.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author lidai
 * @date 2019/7/3 11:36
 * <p>
 * 使用HQL一定要用实体类中映射得属性
 * 注：@Query 注解用于声明查询操作，当操作不是查询时需要时用@Modifying注解声明操作，且需要添加事务支持
 *      nativeQuery = true 时代表使用本地查询，即正常sql查询，false为使用jpql查询
 */
public interface UserRepository extends BaseRepository<User, Integer> {

    User findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "delete from User where userId in (?1)")
    void batchDeleteByUserIds(Integer[] userIds);
    
}

