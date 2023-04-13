package com.moonerhigh.taste.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author zpLone
 * @Date 2023/4/4 18:23
 * @PackageName:com.moonerghig.taste.server
 * @ClassName: TasteServerApplication
 * @Description: 管理后台启动类
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.moonerhigh")
public class TasteServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TasteServerApplication.class);
    }
}
