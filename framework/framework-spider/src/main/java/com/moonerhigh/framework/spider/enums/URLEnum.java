package com.moonerhigh.framework.spider.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author zpLone
 * @Date 2023/4/19 19:14
 * @PackageName:com.moonerhigh.framework.spider.enums
 * @ClassName: URLEnum
 * @Description: 链接枚举
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum URLEnum {


    OFFICE_ADDRESS_AND_CONTACT_INFORMATION("办公地址及联系方式","http://www.js.sgcc.com.cn/html/szgdgs/col2882/2020-09/25/20200925123454087954196_1.html"),

    COMPANY_QUALIFICATION("公司资质","http://www.js.sgcc.com.cn/html/szgdgs/col2882/2021-10/18/20211018175232066138978_1.html"),

    BUSINESS_OUTLET_INFORMATION("营业网点信息","http://www.js.sgcc.com.cn/html/szgdgs/col2882/2019-07/19/20190719154004592917345_1.html"),

    REGULAR_REGULATIONS("政策法规","http://www.js.sgcc.com.cn/html/szgdgs/col2887/column_2887_1.html"),

    POWER_SUPPLY_QUALITY_STANDARD("供电质量标准","http://www.js.sgcc.com.cn/html/szgdgs/col2887/2022-07/21/20220721121415989514310_1.html"),

    MANAGEMENT_MEASURES_FOR_ELECTRIC_POWER_RELIABILITY("电力可靠性管理办法","http://www.js.sgcc.com.cn/html/szgdgs/col2887/2022-05/05/20220505111449584486302_1.html"),

    POWER_SUPPLY_QUALITY_AND_VOLTAGE_QUALIFICATION_RATE("供电质量及“两率”情况","http://www.js.sgcc.com.cn/html/szgdgs/col2886/column_2886_1.html"),

    MAINTENANCE_ANNOUNCEMENT("电网检修公告","https://www.95598.cn/osgweb/blackoutNotice?partNo=P050302&province=320000&city=320500&county=320571&powerCutNo=01"),

    SUZHOU_OPEN_CAPACITY_REPORT_QUARTER_1("苏州开放容量报告（第一季度）","http://www.js.sgcc.com.cn/html/szgdgs/col2884/2022-04/02/20220402110009407721380_1.html"),

    SUZHOU_OPEN_CAPACITY_REPORT_QUARTER_2("苏州开放容量报告（第二季度）","http://www.js.sgcc.com.cn/html/szgdgs/col2884/2022-07/19/20220719160109877152745_1.html"),

    SUZHOU_OPEN_CAPACITY_REPORT_QUARTER_3("苏州开放容量报告（第三季度）","http://www.js.sgcc.com.cn/html/szgdgs/col2884/2023-02/10/20230210100254654179458_1.html"),

    SUZHOU_OPEN_CAPACITY_REPORT_QUARTER_4("苏州开放容量报告（第四季度）","http://www.js.sgcc.com.cn/html/szgdgs/col2884/2023-02/10/20230210100522744600676_1.html"),

    SUZHOU_POWER_SUPPLY_COMPANY_GRID_ACCESS_RESTRICTION_LIST_QUARTER_1("苏州供电公司电网接入受限清单（2022年一季度）","http://www.js.sgcc.com.cn/html/szgdgs/col2884/2022-04/24/20220424152921386527649_1.html"),

    SUZHOU_POWER_SUPPLY_COMPANY_GRID_ACCESS_RESTRICTION_LIST_QUARTER_2("苏州电网受限接入配电线路清单","http://www.js.sgcc.com.cn/html/szgdgs/col2884/2022-07/19/20220719182329213534654_1.html"),

    SUZHOU_POWER_SUPPLY_COMPANY_GRID_ACCESS_RESTRICTION_LIST_QUARTER_3("苏州电网受限接入配电线路清单","http://www.js.sgcc.com.cn/html/szgdgs/col2884/2023-02/09/20230209174359204727439_1.html"),

    SUZHOU_POWER_SUPPLY_COMPANY_GRID_ACCESS_RESTRICTION_LIST_QUARTER_4("苏州电网受限接入配电线路清单","http://www.js.sgcc.com.cn/html/szgdgs/col2884/2023-02/09/20230209174612717928975_1.html");

    private final String name;

    private final String value;


}
