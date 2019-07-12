/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.service.impl;

import com.mall.market.entity.ProductBrand;
import com.mall.market.repository.ProductBrandRepository;
import com.mall.market.service.ProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * @author lidai
 * @date 2019/7/12 14:55
 * @since
 */
@Service
@Transactional
public class ProductBrandServiceImpl implements ProductBrandService {

    @Autowired
    private ProductBrandRepository brandRepository;

    @Override
    public void insertProductBrand(ProductBrand brand) {
        brandRepository.save(brand);
    }

    @Override
    public List<ProductBrand> getProductBrandList(String brandName) {
        return brandRepository.findAll((root, query, criteriaBuilder) -> {
            if (StringUtils.hasText(brandName)) {
                Predicate predicate = criteriaBuilder.like(root.get("brandName").as(String.class), "%" + brandName + "%");
                return criteriaBuilder.and(predicate);
            }
            return null;
        }, Sort.by(Sort.Direction.DESC, "brandOrder"));

    }
}

