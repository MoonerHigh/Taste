package com.moonerhigh.framework.datasource.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Author zpLone
 * @Date 2023/5/24 15:26
 * @PackageName:com.moonerhigh.framework.datasource
 * @ClassName: DataSourceAutoConfiguration
 * @Description: 数据库自动配置类
 * @Version 1.0
 */
@AutoConfiguration
@EnableAutoConfiguration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataSourceAutoConfiguration {

}
