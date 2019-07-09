/*
 * Copyright (C), 2013-2019, 天津大海云科技有限公司
 */
package com.mall.admin.configuration;

import com.mall.admin.entity.Permission;
import com.mall.admin.entity.Role;
import com.mall.admin.entity.User;
import com.mall.admin.repository.PermissionRepository;
import com.mall.admin.repository.UserRepository;
import com.sun.org.apache.regexp.internal.RE;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lidai
 * @date 2019/7/9 11:06
 * @since
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService());
//                .passwordEncoder(bCryptPasswordEncoder());

//        auth.inMemoryAuthentication()
//                .withUser("user").password(bCryptPasswordEncoder().encode("123456")).roles("ADMIN");
    }


    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepository.findByUsername(username);
                if(null==user){
                    throw new IllegalArgumentException("用户名不存在");
                }
                List<Permission> permissions = permissionRepository.getPermissionsByUserId(user.getUserId());
                Set<String> perms  = permissions.stream().map(Permission::getPerms).collect(Collectors.toSet());
                List<GrantedAuthority> authorities= AuthorityUtils.createAuthorityList(perms.toArray(new String[]{}));
                return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
            }
        };
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

