///*
// * Copyright (C), 2013-2019, 天津大海云科技有限公司
// */
//package com.mall.admin.configuration;
//
//import com.mall.admin.entity.Role;
//import com.mall.admin.entity.User;
//import com.mall.admin.repository.UserRepository;
//import com.sun.org.apache.regexp.internal.RE;
//import lombok.Setter;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author lidai
// * @date 2019/7/9 11:06
// * @since
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password(bCryptPasswordEncoder().encode("123456")).roles("ADMIN");
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Setter
//    public class CustomerUserDetails implements UserDetails {
//
//        private String username;
//
//        private String password;
//
//        private boolean accountExpired;
//
//        private boolean accountNonLocked;
//
//        private boolean credentialsNonExpired;
//
//        private Collection<? extends GrantedAuthority> authorities;
//
//        @Override
//        public Collection<? extends GrantedAuthority> getAuthorities() {
//            return authorities;
//        }
//
//        @Override
//        public String getPassword() {
//            return password;
//        }
//
//        @Override
//        public String getUsername() {
//            return username;
//        }
//
//        @Override
//        public boolean isAccountNonExpired() {
//            return accountExpired;
//        }
//
//        @Override
//        public boolean isAccountNonLocked() {
//            return accountNonLocked;
//        }
//
//        @Override
//        public boolean isCredentialsNonExpired() {
//            return credentialsNonExpired;
//        }
//
//        @Override
//        public boolean isEnabled() {
//            return true;
//        }
//    }
//}
//
