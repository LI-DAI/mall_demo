/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.service.impl;

import com.mall.admin.entity.Permission;
import com.mall.admin.entity.User;
import com.mall.admin.repository.PermissionRepository;
import com.mall.admin.repository.UserRepository;
import com.mall.admin.service.UserService;
import com.mall.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lidai
 * @date 2019/7/3 13:47
 * @since
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${auth-server}")
    private String oauthUrl;


    /**
     * 动态查询
     * <p>
     * 1、分页从第 0 页开始
     * 2、模糊查询和精确查询参考{@link CriteriaBuilder#equal(Expression, Object)} 和 {@link CriteriaBuilder#like(Expression, String)}
     */
    @Override
    public Page<User> getUserList(String username, String nickname, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.Direction.DESC, "createTime", "updateTime");
        //自定义查询条件
        Specification<User> queryCondition = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (StringUtils.hasText(nickname)) {
                    predicateList.add(criteriaBuilder.like(root.get("nickname").as(String.class), "%" + nickname + "%"));
                }
                if (StringUtils.hasText(username)) {
                    predicateList.add(criteriaBuilder.like(root.get("username").as(String.class), "%" + username + "%"));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        Page<User> users = userRepository.findAll(queryCondition, pageable);
        return users;
    }

    /**
     * 新增
     *
     * @param user
     * @return
     */
    @Override
    public Integer insertUser(User user) {
        Long count = checkUsernameValid(user.getUsername(), user.getUserId());
        if (count > 0) {
            throw new IllegalArgumentException("该用户名已被使用！");
        }
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        return userRepository.save(user).getUserId();
    }

    /**
     * 删除
     *
     * @param userId
     */
    @Override
    public void deleteByUserId(Integer userId) {
        userRepository.deleteById(userId);
    }

    /**
     * 批量删除
     *
     * @param userIds
     */
    @Override
    public void batchDeleteByUserId(Integer[] userIds) {
        userRepository.batchDeleteByUserIds(userIds);
    }

    /**
     * 修改
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        Long count = checkUsernameValid(user.getUsername(), user.getUserId());
        if (count > 0) {
            throw new IllegalArgumentException("该用户名已被使用！");
        }
        user.setUpdateTime(LocalDateTime.now());
        userRepository.saveAndFlush(user);
    }

    /**
     * 根据用户名获取用户
     *
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * 检查用户名是否重复
     *
     * @param username 用户名
     * @param userId   用户id
     * @return
     */
    @Override
    public Long checkUsernameValid(String username, Integer userId) {
        return userRepository.count((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (StringUtils.hasText(username)) {
                predicateList.add(criteriaBuilder.equal(root.get("username"), username));
            }
            if (null != userId) {
                predicateList.add(criteriaBuilder.notEqual(root.get("userId").as(Integer.class), userId));
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        });
    }

    /**
     * 获取用户权限
     *
     * @param userId
     * @return
     */
    @Override
    public List<Permission> getUserPermissions(Integer userId) {
        List<Permission> permissions = permissionRepository.getPermissionsByUserId(userId);
        return getTreePermsList(permissions, 0);
    }

    /**
     * 获取树形结构
     *
     * @param permissions
     * @param parentId
     * @return
     */
    @Override
    public List<Permission> getTreePermsList(List<Permission> permissions, Integer parentId) {
        List<Permission> result = new ArrayList<>();
        permissions.forEach(permission -> {
            if (permission.getParentId().equals(parentId)) {
                permission.setChildren(getTreePermsList(permissions, permission.getPermissionId()));
                result.add(permission);
            }
        });
        return result;
    }

    @Override
    public Result login(User user) {
        MultiValueMap params = new LinkedMultiValueMap();
        params.add("client", "browser");
        params.add("secret", "secret");
        params.add("username", user.getUsername());
        params.add("password", user.getPassword());
        params.add("grant_type", "password");
//        restTemplate.postForObject(oauthUrl + "/token", params);
        return null;
    }
}

