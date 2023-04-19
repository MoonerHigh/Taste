package com.moonerhigh.framework.spider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moonerhigh.framework.spider.entity.SpiderStateGrid;
import com.moonerhigh.framework.spider.enums.ElementEnum;
import com.moonerhigh.framework.spider.enums.URLEnum;
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
import static com.moonerhigh.framework.spider.utils.SplitUtil.getMapByRegex;

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
        document = Jsoup.connect(URLEnum.OFFICE_ADDRESS_AND_CONTACT_INFORMATION.getValue()).get();
        String title = document.title();
        log.info("文章标题:{}", title);
        Document doc = Jsoup.parse(document.body().html());
        String remark = doc.select("div > h1 > span[objid]").stream().findFirst().get().text();
        log.info("页面标题{}", remark);
        Elements spans = doc.select("div span");
        Map<String, String> releaseInfoMap = getMapByRegex(INFO_REGEX, spans);
        log.info("发布信息{}", releaseInfoMap);
        Elements divP = doc.select("div p");
        Map<String, String> addressMap = getMapByRegex(ADDRESS_REGEX, divP);
        log.info("地址信息{}", addressMap);
        // map合并
        addressMap.putAll(releaseInfoMap);
        SpiderStateGrid spiderStateGrid = new SpiderStateGrid()
                .setArticleUrl(URLEnum.OFFICE_ADDRESS_AND_CONTACT_INFORMATION.getValue())
                .setTitle(title)
                .setReleaseDate(addressMap.get(ElementEnum.RELEASE_DATE.getName()))
                .setInfoSources(addressMap.get(ElementEnum.INFO_SOURCES.getName()))
                .setCompanyAddr(addressMap.get(ElementEnum.COMPANY_ADDR.getName()))
                .setFaxNo(addressMap.get(ElementEnum.FAX_NO.getName()))
                .setPhoneNo(addressMap.get(ElementEnum.PHONE_NO.getName()))
                .setRemark(remark);
        spiderStateGridMapper.insert(spiderStateGrid);
    }

    @SneakyThrows
    public void getHtmlImage() {
        Document document;
        document = Jsoup.connect(URLEnum.COMPANY_QUALIFICATION.getValue()).get();
        String title = document.title();
        String html = document.body().html();
        log.info("文章标题{}", title);
        Document doc = Jsoup.parse(html);
        String remark = doc.select("div > h1 > span[objid]").stream().findFirst().get().text();
        log.info("页面标题{}", remark);
        Elements divs = doc.select("div > p > img[src]");
        Elements spans = doc.select("div span");
        Map<String, String> releaseInfoMap = getMapByRegex(INFO_REGEX, spans);
        for (Element element : divs) {
            String src = element.attr("src");
            SpiderStateGrid spiderStateGrid = new SpiderStateGrid()
                    .setTitle(title)
                    .setArticleUrl(URLEnum.COMPANY_QUALIFICATION.getValue())
                    .setImageUrl(new StringBuilder().append(BASE_URL).append(src).toString())
                    .setRemark(remark)
                    .setReleaseDate(releaseInfoMap.get(ElementEnum.RELEASE_DATE.getName()))
                    .setInfoSources(releaseInfoMap.get(ElementEnum.INFO_SOURCES.getName()));
            spiderStateGridMapper.insert(spiderStateGrid);
        }
    }

    @SneakyThrows
    public void getHtmlFile() {
        Document document;
        document = Jsoup.connect(URLEnum.BUSINESS_OUTLET_INFORMATION.getValue()).get();
        String title = document.title();
        String html = document.body().html();
        log.info("文章标题{}", title);
        Document doc = Jsoup.parse(html);
        String remark = doc.select("div > h1 > span[objid]").stream().findFirst().get().text();
        log.info("页面标题{}", remark);
        Elements divs = doc.select("div > p > a[data_ue_src]");
        Elements spans = doc.select("div span");
        Map<String, String> releaseInfoMap = getMapByRegex(INFO_REGEX, spans);
        for (Element element : divs) {
            String fileUrl = element.attr("data_ue_src");
            SpiderStateGrid spiderStateGrid = new SpiderStateGrid()
                    .setTitle(title)
                    .setArticleUrl(URLEnum.BUSINESS_OUTLET_INFORMATION.getValue())
                    .setFileUrl(new StringBuilder().append(BASE_URL).append(fileUrl).toString())
                    .setRemark(remark)
                    .setReleaseDate(releaseInfoMap.get(ElementEnum.RELEASE_DATE.getName()))
                    .setInfoSources(releaseInfoMap.get(ElementEnum.INFO_SOURCES.getName()));
            spiderStateGridMapper.insert(spiderStateGrid);
        }
    }

    // 爬取页面4
    @SneakyThrows
    public void getNotice() {
        Document document;
        document = Jsoup.connect(URLEnum.REGULAR_REGULATIONS.getValue()).get();
        String title = document.title();
        String html = document.body().html();
        log.info("文章标题{}", title);
        Document doc = Jsoup.parse(html);
        String remark = doc.select("div > h1 > span[objid]").stream().findFirst().get().text();
        log.info("页面标题{}", remark);
        // div[objid=6014]
        Elements spans = doc.select("div p span");
        StringBuilder stringBuilder = new StringBuilder();
        String notice = null;
        Map<String, String> releaseInfoMap = getMapByRegex(INFO_REGEX, spans);
        for (Element element : spans) {
            notice = stringBuilder.append(element.text()).toString();
        }
        log.info("正文{}", notice);
        SpiderStateGrid spiderStateGrid = new SpiderStateGrid()
                .setTitle(title)
                .setRemark(remark)
                .setArticleContent(notice)
                .setArticleUrl(URLEnum.REGULAR_REGULATIONS.getValue())
                .setReleaseDate(releaseInfoMap.get(ElementEnum.RELEASE_DATE.getName()))
                .setInfoSources(releaseInfoMap.get(ElementEnum.INFO_SOURCES.getName()));
        spiderStateGridMapper.insert(spiderStateGrid);
    }

}