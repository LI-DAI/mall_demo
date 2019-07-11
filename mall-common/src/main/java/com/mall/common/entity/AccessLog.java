/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lidai
 * @date 2019/7/11 15:02
 * @since
 */
@Data
public class AccessLog {

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime startTime;

    private String username;

    private String url;

    private String method;

    private String description;

    private String ip;

    private Object parameter;

    private Long duration;

    private Object result;
}

