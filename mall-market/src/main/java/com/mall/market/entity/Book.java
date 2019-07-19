/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author lidai
 * @date 2019/7/17 13:37
 * <p>
 * es功能测试类
 */
@Data
@Document(indexName = "mall_demo", type = "Book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer id;

    private String name;

    private Integer price;

}

