/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.repository.es;

import com.mall.market.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author lidai
 * @date 2019/7/17 13:38
 * @since
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

}

