/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.repository.es;

import com.mall.market.entity.Book;
import com.mall.market.entity.ProductBrand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @author lidai
 * @date 2019/7/17 10:44
 * @since
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ProductBrandESRepository productBrandESRepository;

    @Test
    public void test_1() {
        Book book = new Book(1, "没有什么会永垂不朽", 100);
        bookRepository.index(book);
    }

    @Test
    public void test_2() {
        Optional<Book> book = bookRepository.findById(1);
        System.out.println(book);
    }

    @Test
    public void test_3() {
        ProductBrand productBrand = new ProductBrand(
                1l,
                "name",
                "13111111111",
                "www.baidu.com",
                "类别一",
                "/home.jpg",
                "0",
                1);
        productBrandESRepository.index(productBrand);
    }
}

