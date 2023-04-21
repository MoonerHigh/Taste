package com.moonerhigh.framework.spider.controller;

import com.moonerhigh.framework.spider.service.SpiderStateGridService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zpLone
 * @Date 2023/4/16 19:01
 * @PackageName:com.moonerhigh.framework.spider.controller
 * @ClassName: SpiderStateGridController
 * @Description: (SpiderStateGrid)表控制层
 * @Version 1.0
 */
@RestController
@RequestMapping("spider/spiderStateGrid")
public class SpiderStateGridController {

    @Resource
    private SpiderStateGridService spiderStateGridService;

    @GetMapping("/spider")
    public void spider(){
        spiderStateGridService.spider();
    }

    @GetMapping("/driver")
    public void driver(){
        spiderStateGridService.driver();
    }
}
