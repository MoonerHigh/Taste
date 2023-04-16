package com.moonerhigh.framework.spider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.moonerhigh.framework.spider.entity.SpiderStateGrid;

/**
 * (SpiderStateGrid)表服务接口
 *
 * @author zpLone
 * @since 2023-04-16 17:56:25
 */
public interface SpiderStateGridService extends IService<SpiderStateGrid> {

    /**
     * 获取第一页数据
     */
    void getPage1();
}

