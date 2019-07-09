///*
// * Copyright (C), 2013-2019, 天津大海云科技有限公司
// */
//package com.mall.admin.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
//
//import javax.sql.DataSource;
//
///**
// * @author lidai
// * @date 2019/7/9 14:16
// * <p>
// * 认证服务器
// */
//@Configuration
//@EnableAuthorizationServer
////@AutoConfigureAfter(DruidConfiguration.class)
//public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    private DataSource dataSource;
//
////    @Autowired
////    private RedisTokenStore redisTokenStore;
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//
////        clients
////                .inMemory()
////                .withClient("client")
////                .secret(passwordEncoder.encode("secret"))
////                //授权类型
////                .authorizedGrantTypes("authorization_code")
////                .scopes("app")
////                //注册回调地址
////                .redirectUris("http://www.funtl.com");
//        //自动从数据库查数据
//        clients.withClientDetails(jdbcClientDetails());
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.tokenStore(tokenStore());
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new JdbcTokenStore(dataSource);
//    }
//
//    @Bean
//    public ClientDetailsService jdbcClientDetails(){
//        return new JdbcClientDetailsService(dataSource);
//    }
//
//}
//
