package com.moonerhigh.framework.spider.constants;

/**
 * @Author zpLone
 * @Date 2023/4/16 18:16
 * @PackageName:com.moonerhigh.framework.spider.constants
 * @ClassName: Const
 * @Description: 业务常量类
 * @Version 1.0
 */
public class Const {

    public static final String URL = "http://www.js.sgcc.com.cn/html/szgdgs/col2882/2020-09/25/20200925123454087954196_1.html";

    public static final String ADDRESS_REGEX = "(公司地址|邮 箱|传 真|联 系 电 话)：([^\\s]+)";

    public static final String INFO_REGEX = "(发布日期|信息来源)：\\s*([^\\\\s]+)";
}
