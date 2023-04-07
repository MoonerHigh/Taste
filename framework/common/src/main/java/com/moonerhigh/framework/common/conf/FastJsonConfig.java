package com.moonerhigh.framework.common.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Author zpLone
 * @Date 2023/4/7 9:24
 * @PackageName:com.moonerhigh.framework.common.conf
 * @ClassName: FastJsonConfig
 * @Description: 使用FastJson2进行json格式处理
 * @Version 1.0
 */
@Configuration
public class FastJsonConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.extendMessageConverters(converters);
    }
}
