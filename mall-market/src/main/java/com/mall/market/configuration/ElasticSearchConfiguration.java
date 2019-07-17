/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author lidai
 * @date 2019/7/17 14:29
 * @since
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.mall.market.repository.jpa")
@EnableElasticsearchRepositories(basePackages = "com.mall.market.repository.es")
public class ElasticSearchConfiguration {

}

