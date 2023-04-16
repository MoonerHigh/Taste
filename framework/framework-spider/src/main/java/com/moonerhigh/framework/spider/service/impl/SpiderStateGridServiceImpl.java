package com.moonerhigh.framework.spider.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moonerhigh.framework.spider.entity.SpiderStateGrid;
import com.moonerhigh.framework.spider.mapper.SpiderStateGridMapper;
import com.moonerhigh.framework.spider.service.SpiderStateGridService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static com.moonerhigh.framework.spider.constants.Const.*;
import static com.moonerhigh.framework.spider.utils.SplitUtil.extractInfo;

/**
 * (SpiderStateGrid)表服务实现类
 *
 * @author zpLone
 * @since 2023-04-16 17:56:27
 */

@Slf4j
@Service("spiderStateGridService")
public class SpiderStateGridServiceImpl extends ServiceImpl<SpiderStateGridMapper, SpiderStateGrid> implements SpiderStateGridService {
    @Override
    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public void getInfo() {
        Document document;
        document = Jsoup.connect(URL).get();
        String title = document.title();
        log.info("文章标题 {}", title);
        Document doc = Jsoup.parse(document.body().html());
        Elements elements = doc.select("div span");
        getMap(INFO_REGEX, elements);
        Elements divP = doc.select("div p");
        getMap(ADDRESS_REGEX, divP);
    }

    private static void getMap(String addressRegex, Elements divP) {
        for (Element element : divP) {
            Map<String, String> infoMap = extractInfo(element.text(), addressRegex);
            for (Map.Entry<String, String> entry : infoMap.entrySet()) {
                log.info(entry.getKey(), entry.getKey());
            }
        }
    }

}


