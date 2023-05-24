package com.moonerhigh.framework.web.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * @Author zpLone
 * @Date 2023/5/23 18:20
 * @PackageName:com.moonerhigh.framework.web
 * @ClassName: WebProperties
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Validated
@ConfigurationProperties()
public class WebProperties {
    

    @Data
    @Validated
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Api {


        @NotEmpty(message = "API 前缀不能为空")
        private String prefix;


        private String controller;


    }


}
