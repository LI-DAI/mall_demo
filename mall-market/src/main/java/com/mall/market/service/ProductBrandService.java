/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.service;

import com.mall.market.entity.ProductBrand;

import java.util.List;

/**
 * @author lidai
 * @date 2019/7/12 14:55
 * @since
 */
public interface ProductBrandService {

    void insertProductBrand(ProductBrand brand);

    List<ProductBrand> getProductBrandList(String brandName);
}

