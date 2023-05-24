package com.moonerhigh.framework.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @Author zpLone
 * @Date 2023/5/24 15:30
 * @PackageName:com.moonerhigh.framework.mybatis.config
 * @ClassName: MyBatisAutoConfiguration
 * @Description: Mybatis自动配置类
 * @Version 1.0
 */
@AutoConfiguration
public class MyBatisAutoConfiguration {

    /*
     * @description: 分页插件
     * @date: 2023/5/24 15:51
     * @param:  * @param
     * @return: {@link com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor}
     **/
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }



}
