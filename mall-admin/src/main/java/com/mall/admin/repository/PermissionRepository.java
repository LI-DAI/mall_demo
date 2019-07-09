package com.mall.admin.repository;

import com.mall.admin.entity.Permission;
import com.mall.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @auther lidai
 * @create 2019/7/9 21:53
 */
public interface PermissionRepository extends BaseRepository<Permission, Integer> {

    @Query(nativeQuery = true, value = "select distinct sp.* from sys_user su " +
            "left join sys_user_role sur on su.user_id = sur.user_id " +
            "left join sys_role sr on sur.role_id = sr.role_id " +
            "left join sys_role_permission srp on sr.role_id = srp.role_id " +
            "left join sys_permission sp on srp.permission_id = sp.permission_id where su.user_id = ?1")
    List<Permission> getPermissionsByUserId(Integer userId);

}
