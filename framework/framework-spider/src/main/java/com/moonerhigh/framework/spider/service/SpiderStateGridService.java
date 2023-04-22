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
     * 分类抓取数据
     */
    void spider();
    /**
     * 使用webDriver点击按钮获取数据
     */
    /**
     * 爬取供电质量及“两率”情况
     */
    void getPage2();
    /**
     * 政策法规
     */
    void getPage3();
}

