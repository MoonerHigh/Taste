package com.moonerhigh.taste.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zpLone
 * @Date 2023/4/13 18:20
 * @PackageName:com.moonerhigh.taste.server.controller
 * @ClassName: DemoController
 * @Description: 启动测试
 * @Version 1.0
 */
@RestController
@RequestMapping("/server/demo")
public class DemoController {

    @GetMapping("/demo")
    public String demo(){
        return new String("hello-world!");
    }
}
