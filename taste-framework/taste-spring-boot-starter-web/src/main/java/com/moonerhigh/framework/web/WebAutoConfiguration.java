package com.moonerhigh.framework.web;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author zpLone
 * @Date 2023/5/22 15:24
 * @PackageName:com.moonerhigh.framework.web
 * @ClassName: WebAutoConfiguration
 * @Description: Web自动配置类
 * @Version 1.0
 */
@AutoConfiguration
@EnableAutoConfiguration(exclude = WebProperties.class)
public class WebAutoConfiguration implements WebMvcConfigurer {



}
