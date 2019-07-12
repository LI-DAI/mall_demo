/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.repository;

import com.mall.common.repository.BaseRepository;
import com.mall.market.entity.ProductBrand;

import java.util.List;

/**
 * @author lidai
 * @date 2019/7/12 14:54
 * @since
 */
public interface ProductBrandRepository extends BaseRepository<ProductBrand, Long> {

    List<ProductBrand> findProductBrandsByBrandNameLike(String brandName);

}

