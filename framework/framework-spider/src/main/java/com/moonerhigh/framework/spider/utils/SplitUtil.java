package com.moonerhigh.framework.spider.utils;

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
}
