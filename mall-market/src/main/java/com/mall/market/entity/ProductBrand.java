/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lidai
 * @date 2019/7/12 14:46
 * <p>
 * 品牌信息
 */
@Data
@Entity
@Table(name = "market_product_brand")
@NoArgsConstructor
@AllArgsConstructor
//声明存储于索引库为mall_demo下，类型为ProductBrand
@Document(indexName = "mall_product_brand", type = "ProductBrand")
public class ProductBrand implements Serializable {

    private static final long serialVersionUID = 4066518364159966368L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long id;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "brand_web")
    private String brandWeb;

    @Column(name = "brand_desc")
    private String brandDesc;

    @Column(name = "brand_logo")
    private String brandLogo;

    @Column(name = "brand_status")
    private String brandStatus;

    @Column(name = "brand_order")
    private Integer brandOrder;


}

