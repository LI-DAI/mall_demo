/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author lidai
 * @date 2019/7/3 11:23
 * @since
 */
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

}

