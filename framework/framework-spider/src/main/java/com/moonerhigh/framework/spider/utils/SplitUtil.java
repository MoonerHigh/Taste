package com.moonerhigh.framework.spider.utils;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author zpLone
 * @Date 2023/4/16 18:10
 * @PackageName:com.moonerhigh.framework.spider.utils
 * @ClassName: SplitUtil
 * @Description: 页面数据组装工具类
 * @Version 1.0
 */
public class SplitUtil {

    /**
     * @description: 正则表达式匹配页面元素，组装成Map返回
     * @author: zpLone
     * @date: 2023/4/19 13:07
     * @param:  * @param text
     * @param regex
     * @return: {@link Map< String, String>}
     **/
    public static Map<String, String> extractInfo(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        Map<String, String> infoMap = new HashMap<>();
        while (matcher.find()) {
            String infoKey = matcher.group(1);
            String infoValue = matcher.group(2);
            infoMap.put(infoKey, infoValue);
        }
        return infoMap;
    }

    /**
     * @param divP
     * @description: 页面元素转Map
     * @author: zpLone
     * @date: 2023/4/18 20:04
     * @param: * @param 正则表达式
     * @return: {@link Map< String, String>}
     **/
    public static Map<String, String> getMapByRegex(String regex, Elements divP) {
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
