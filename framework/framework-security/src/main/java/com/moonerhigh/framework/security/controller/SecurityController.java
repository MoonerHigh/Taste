package com.moonerhigh.framework.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zpLone
 * @Date 2023/4/13 18:05
 * @PackageName:com.moonerhigh.framework.security
 * @ClassName: Controller
 * @Description: SpringSecurity测试
 * @Version 1.0
 */
@RestController
@RequestMapping("/security/demo")
public class SecurityController {

    @GetMapping("/demo")
    public String demo(){
        return new String("demo");
    }
}
