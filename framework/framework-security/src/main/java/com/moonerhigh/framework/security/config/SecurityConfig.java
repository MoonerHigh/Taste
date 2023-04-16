package com.moonerhigh.framework.security.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @Author zpLone
 * @Date 2023/4/15 14:55
 * @PackageName:com.moonerhigh.framework.security.config
 * @ClassName: SecurityConfig
 * @Description: SpringSecurity配置类
 * @Version 1.0
 */
@Configuration
public class SecurityConfig {

    // ======= WebSecurityConfigurerAdapter已被官方弃用,请使用SecurityFilterChain ======= //

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.formLogin(login -> login
//                // 请求指定URL时，进行登录认证
//                .loginProcessingUrl("/login")
//                // 指定用于登录的URL
//                .loginPage("/login")
//                // 认证成功后重定向位置
//                .defaultSuccessUrl("/")
//                // 认证失败后重定向位置
//                .failureUrl("/login?error")
//                // 有无访问权限（permitAll允许所有用户访问）
//                .permitAll()
//        ).logout(logout -> logout
//                        // 登出后重定向位置
//                        .logoutSuccessUrl("/")
//                // 访问限制
//        ).authorizeHttpRequests(authorize -> authorize
//                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                // 所有其他链接都需要认证
//                .anyRequest().authenticated()
//        );
//        return httpSecurity.build();
//    }
}
