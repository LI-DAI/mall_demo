/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.repository.es;

import com.mall.market.entity.ProductBrand;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author lidai
 * @date 2019/7/17 11:44
 * @since
 */
public interface ProductBrandESRepository extends ElasticsearchRepository<ProductBrand, Long> {

}
