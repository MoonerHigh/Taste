package com.moonerhigh.framework.spider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moonerhigh.framework.spider.entity.SpiderStateGrid;
import com.moonerhigh.framework.spider.enums.SpiderEnum;
import com.moonerhigh.framework.spider.mapper.SpiderStateGridMapper;
import com.moonerhigh.framework.spider.service.SpiderStateGridService;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
@Transactional(rollbackFor = Exception.class)
public class SpiderStateGridServiceImpl extends ServiceImpl<SpiderStateGridMapper, SpiderStateGrid> implements SpiderStateGridService {

    @Resource
    SpiderStateGridMapper spiderStateGridMapper;

    @Override
    @SneakyThrows
    public void getPage1() {
        Document document;
        document = Jsoup.connect(URL_1).get();
        String title = document.title();
        log.info("文章标题:{}", title);
        Document doc = Jsoup.parse(document.body().html());
        String remark = doc.select("div > h1 > span[objid]").stream().findFirst().get().text();
        log.info("页面标题{}", remark);
        Elements spans = doc.select("div span");
        Map<String, String> releaseInfoMap = getMap(INFO_REGEX, spans);
        log.info("发布信息{}", releaseInfoMap);
        Elements divP = doc.select("div p");
        Map<String, String> addressMap = getMap(ADDRESS_REGEX, divP);
        log.info("地址信息{}", addressMap);
        // map合并
        addressMap.putAll(releaseInfoMap);
        SpiderStateGrid spiderStateGrid = new SpiderStateGrid();
        spiderStateGrid.setArticleUrl(URL_1);
        spiderStateGrid.setTitle(title);
        spiderStateGrid.setReleaseDate(addressMap.get(SpiderEnum.RELEASE_DATE.getName()));
        spiderStateGrid.setInfoSources(addressMap.get(SpiderEnum.INFO_SOURCES.getName()));
        spiderStateGrid.setCompanyAddr(addressMap.get(SpiderEnum.COMPANY_ADDR.getName()));
        spiderStateGrid.setFaxNo(addressMap.get(SpiderEnum.FAX_NO.getName()));
        spiderStateGrid.setPhoneNo(addressMap.get(SpiderEnum.PHONE_NO.getName()));
        spiderStateGrid.setRemark(remark);
        spiderStateGridMapper.insert(spiderStateGrid);
    }

    @SneakyThrows
    public void getPage2() {
        Document document;
        document = Jsoup.connect(URL_1).get();
        String title = document.title();
        String html = document.body().html();
        log.info("文章标题{}", title);
        Document doc = Jsoup.parse(html);
        String remark = doc.select("div > h1 > span[objid]").stream().findFirst().get().text();
        log.info("页面标题{}", remark);
        Elements divs = doc.select("div > p > img[src]");
        Elements spans = doc.select("div span");
        Map<String, String> releaseInfoMap = getMap(INFO_REGEX, spans);
        for (Element element : divs) {
            String src = element.attr("src");
            SpiderStateGrid spiderStateGrid = new SpiderStateGrid();
            spiderStateGrid.setTitle(title);
            spiderStateGrid.setArticleUrl(URL_2);
            spiderStateGrid.setImageUrl(new StringBuilder().append(BASE_URL).append(src).toString());
            spiderStateGrid.setRemark(remark);
            spiderStateGrid.setReleaseDate(releaseInfoMap.get(SpiderEnum.RELEASE_DATE.getName()));
            spiderStateGrid.setInfoSources(releaseInfoMap.get(SpiderEnum.INFO_SOURCES.getName()));
            spiderStateGridMapper.insert(spiderStateGrid);
        }
    }

    @SneakyThrows
    public void getPage3(){
        Document document;
        document = Jsoup.connect(URL_1).get();
        String title = document.title();
        String html = document.body().html();
        log.info("文章标题{}", title);
        Document doc = Jsoup.parse(html);
        String remark = doc.select("div > h1 > span[objid]").stream().findFirst().get().text();
        log.info("页面标题{}", remark);
        Elements divs = doc.select("div > p > a[data_ue_src]");
        Elements spans = doc.select("div span");
        Map<String, String> releaseInfoMap = getMap(INFO_REGEX, spans);
        for (Element element : divs) {
            String fileUrl = element.attr("data_ue_src");
            SpiderStateGrid spiderStateGrid = new SpiderStateGrid();
            spiderStateGrid.setTitle(title);
            spiderStateGrid.setArticleUrl(URL_3);
            spiderStateGrid.setFileUrl(new StringBuilder().append(BASE_URL).append(fileUrl).toString());
            spiderStateGrid.setRemark(remark);
            spiderStateGrid.setReleaseDate(releaseInfoMap.get(SpiderEnum.RELEASE_DATE.getName()));
            spiderStateGrid.setInfoSources(releaseInfoMap.get(SpiderEnum.INFO_SOURCES.getName()));
            spiderStateGridMapper.insert(spiderStateGrid);
        }
    }

    /**
     * @param divP
     * @description: 页面元素转Map
     * @author: zpLone
     * @date: 2023/4/18 20:04
     * @param: * @param 正则表达式
     * @return: {@link Map< String, String>}
     **/
    private Map<String, String> getMap(String regex, Elements divP) {
        Map<String, String> infoMap = null;
        for (Element element : divP) {
            infoMap = extractInfo(element.text(), regex);
            if (!infoMap.isEmpty()) {
                return infoMap;
            }
        }
        return infoMap;
    }

}