/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.market.controller;

import com.mall.common.entity.Result;
import com.mall.market.entity.ProductBrand;
import com.mall.market.service.ProductBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lidai
 * @date 2019/7/12 15:10
 * @since
 */
@RestController
@RequestMapping("/brand")
@Api(value = "品牌信息操作")
public class ProductBrandController {

    @Autowired
    private ProductBrandService brandService;

    @PostMapping("/insert")
    @ApiOperation(value = "新增品牌", httpMethod = "POST")
    public Result insertProductBrand(@RequestBody ProductBrand productBrand) {
        try {
            brandService.insertProductBrand(productBrand);
            return Result.build().success("新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build().fail(e.getMessage());
        }
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取所有品牌", httpMethod = "GET")
    @ApiImplicitParam(paramType = "query", name = "brandName", value = "品牌名称", dataType = "String")
    public Result getProductBrandList(String brandName) {
        try {
            List<ProductBrand> productBrandList = brandService.getProductBrandList(brandName);
            return Result.build().success("获取成功", productBrandList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build().fail(e.getMessage());
        }

    }
}

