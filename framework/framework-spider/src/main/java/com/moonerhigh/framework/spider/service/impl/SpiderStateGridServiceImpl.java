package com.moonerhigh.framework.spider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moonerhigh.framework.spider.entity.SpiderStateGrid;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.moonerhigh.framework.spider.constants.Const.ADDRESS_REGEX;
import static com.moonerhigh.framework.spider.constants.Const.BASE_URL;
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

    @SneakyThrows
    public void getPage1() {
        Document document;
        document = Jsoup.connect(URLEnum.OFFICE_ADDRESS_AND_CONTACT_INFORMATION.getValue()).get();
        String title = document.title();
        log.info("文章标题:{}", title);
        Document doc = Jsoup.parse(document.body().html());
        String remark = doc.select("div > h1 > span[objid]").stream().findFirst().get().text();
        log.info("页面标题{}", remark);
        String releaseDate = doc.select("span[objparam='fieldname:DateTime']").first().text();
        String author = doc.select("span[objparam='fieldname:Author']").first().text();
        Elements divP = doc.select("div p");
        Map<String, String> addressMap = getMapByRegex(ADDRESS_REGEX, divP);
        log.info("地址信息{}", addressMap);
        SpiderStateGrid spiderStateGrid = new SpiderStateGrid()
                .setArticleUrl(URLEnum.OFFICE_ADDRESS_AND_CONTACT_INFORMATION.getValue())
                .setTitle(title)
                .setReleaseDate(releaseDate)
                .setAuthor(author)
                .setCompanyAddr(addressMap.get("公司地址"))
                .setFaxNo(addressMap.get("传 真"))
                .setPhoneNo(addressMap.get("联 系 电 话"))
                .setRemark(remark);
        spiderStateGridMapper.insert(spiderStateGrid);
    }

    @SneakyThrows
    public void getHtmlImage(String url) {
        Document document;
        document = Jsoup.connect(url).get();
        String title = document.title();
        String html = document.body().html();
        log.info("文章标题{}", title);
        Document doc = Jsoup.parse(html);
        String remark = doc.select("div > h1 > span[objid]").stream().findFirst().get().text();
        log.info("页面标题{}", remark);
        Elements divs = doc.select("div > p > img[src]");
        String releaseDate = doc.select("span[objparam='fieldname:DateTime']").first().text();
        String author = doc.select("span[objparam='fieldname:Author']").first().text();
        for (Element element : divs) {
            String src = element.attr("src");
            log.info("图片链接:{}", src);
            SpiderStateGrid spiderStateGrid = new SpiderStateGrid()
                    .setTitle(title)
                    .setArticleUrl(url)
                    .setImageUrl(new StringBuilder().append(BASE_URL).append(src).toString())
                    .setRemark(remark)
                    .setReleaseDate(releaseDate)
                    .setAuthor(author);
            spiderStateGridMapper.insert(spiderStateGrid);
        }
    }

    @SneakyThrows
    public void getHtmlFile(String url) {
        Document document;
        document = Jsoup.connect(url).get();
        String title = document.title();
        String html = document.body().html();
        log.info("文章标题{}", title);
        Document doc = Jsoup.parse(html);
        String remark = doc.select("div > h1 > span[objid]").stream().findFirst().get().text();
        log.info("页面标题{}", remark);
        Elements divs = doc.select("div > p > a[data_ue_src]");
        String releaseDate = doc.select("span[objparam='fieldname:DateTime']").first().text();
        String author = doc.select("span[objparam='fieldname:Author']").first().text();
        String fileName = doc.select("div[objid=6014]").first().text();
        for (Element element : divs) {
            String fileUrl = element.attr("data_ue_src");
            SpiderStateGrid spiderStateGrid = new SpiderStateGrid()
                    .setTitle(title)
                    .setArticleUrl(url)
                    .setFileUrl(new StringBuilder().append(BASE_URL).append(fileUrl).toString())
                    .setRemark(remark)
                    .setReleaseDate(releaseDate)
                    .setAuthor(author)
                    .setFileName(fileName);
            spiderStateGridMapper.insert(spiderStateGrid);
        }
    }

    @SneakyThrows
    public void getNotice(String url) {
        Document document;
        document = Jsoup.connect(url).get();
        String title = document.title();
        String html = document.body().html();
        log.info("文章标题{}", title);
        Document doc = Jsoup.parse(html);
        String remark = doc.select("div > h1 > span[objid]").stream().findFirst().get().text();
        log.info("页面标题{}", remark);
        // div[objid=6014]
        Elements spans = doc.select("div p span");
        String releaseDate = doc.select("span[objparam='fieldname:DateTime']").first().text();
        String author = doc.select("span[objparam='fieldname:Author']").first().text();
        StringBuilder stringBuilder = new StringBuilder();
        String notice = null;
        for (Element element : spans) {
            notice = stringBuilder.append(element.text()).toString();
        }
        log.info("正文{}", notice);
        SpiderStateGrid spiderStateGrid = new SpiderStateGrid()
                .setTitle(title)
                .setRemark(remark)
                .setNotice(notice)
                .setArticleUrl(url)
                .setReleaseDate(releaseDate)
                .setAuthor(author);
        spiderStateGridMapper.insert(spiderStateGrid);
    }

    @Override
    public void spider() {
        getPage1();
        List<String> images = new ArrayList<>();
        images.add(URLEnum.COMPANY_QUALIFICATION.getValue());
        images.add(URLEnum.SUZHOU_POWER_SUPPLY_COMPANY_GRID_ACCESS_RESTRICTION_LIST_QUARTER_1.getValue());
        images.add(URLEnum.MANAGEMENT_MEASURES_FOR_ELECTRIC_POWER_RELIABILITY.getValue());
        images.stream().forEach(image -> {
            getHtmlImage(image);
        });
        List<String> files = new ArrayList<>();
        files.add(URLEnum.BUSINESS_OUTLET_INFORMATION.getValue());
        files.add(URLEnum.SUZHOU_OPEN_CAPACITY_REPORT_QUARTER_1.getValue());
        files.add(URLEnum.SUZHOU_OPEN_CAPACITY_REPORT_QUARTER_2.getValue());
        files.add(URLEnum.SUZHOU_OPEN_CAPACITY_REPORT_QUARTER_3.getValue());
        files.add(URLEnum.SUZHOU_OPEN_CAPACITY_REPORT_QUARTER_4.getValue());
        files.stream().forEach(file -> {
            getHtmlFile(file);
        });
        List<String> notices = new ArrayList<>();
        notices.add(URLEnum.POWER_SUPPLY_QUALITY_STANDARD.getValue());
        notices.add(URLEnum.SUZHOU_POWER_SUPPLY_COMPANY_GRID_ACCESS_RESTRICTION_LIST_QUARTER_2.getValue());
        notices.add(URLEnum.SUZHOU_POWER_SUPPLY_COMPANY_GRID_ACCESS_RESTRICTION_LIST_QUARTER_3.getValue());
        notices.add(URLEnum.SUZHOU_POWER_SUPPLY_COMPANY_GRID_ACCESS_RESTRICTION_LIST_QUARTER_4.getValue());
        notices.stream().forEach(notice -> {
            getNotice(notice);
        });
    }


    @Override
    public void driver() {

    }

    @Override
    @SneakyThrows
    public void getPage2() {
        Document document;
        document = Jsoup.connect(URLEnum.POWER_SUPPLY_QUALITY_AND_VOLTAGE_QUALIFICATION_RATE.getValue()).get();
        String html = document.body().html();
        Document doc = Jsoup.parse(html);
        Elements links = doc.select("div > ul > li > a[href]");
        links.forEach(link -> {
            String href = new StringBuilder().append(BASE_URL).append(link.attr("href")).toString();
            String remark = link.text();
            log.info("链接:{}", href);
            log.info("标题:{}", remark);
            getTable(href, link.text());
//            getNotice(new StringBuilder().append(BASE_URL).append(link.attr("href")).toString());
        });
    }

    @SneakyThrows
    private void getTable(String href, String text) {
        Document document;
        document = Jsoup.connect(href).get();
        String html = document.body().html();
        Document doc = Jsoup.parse(html);
        Elements tables = doc.select("table");
        tables.forEach(table -> {
            Elements trs = table.select("tr");
            trs.forEach(tr -> {
                Elements tds = tr.select("td");
                tds.forEach(td -> {
                    log.info("td:{}", td.text());
                });
            });
        });
    }
}
