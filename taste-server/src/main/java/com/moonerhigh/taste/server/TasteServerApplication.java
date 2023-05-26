package com.moonerhigh.taste.server;

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
