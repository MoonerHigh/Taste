package com.moonerhigh.framework.spider.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author zpLone
 * @Date 2023/4/17 14:37
 * @PackageName:com.moonerhigh.framework.spider.enums
 * @ClassName: SpiderUnum
 * @Description: 爬虫枚举
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum ElementEnum {

    RELEASE_DATE("发布日期","release_date"),
    INFO_SOURCES("文章来源","info_sources"),
    COMPANY_ADDR("公司地址","company_addr"),
    MAIL("邮 箱","mail"),
    FAX_NO("传 真","fax_no"),
    PHONE_NO("联 系 电 话","phone_no");

    private final String name;

    private final String value;

}
