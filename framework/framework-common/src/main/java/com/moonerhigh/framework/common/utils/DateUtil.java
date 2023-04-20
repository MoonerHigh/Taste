package com.moonerhigh.framework.common.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Author zpLone
 * @Date 2023/4/12 12:00
 * @PackageName:com.moonerhigh.framework.common.utils
 * @ClassName: DateUtil
 * @Description: 日期工具类
 * @Version 1.0
 */
public class DateUtil extends DateUtils {
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static Long dateDiff(Date startTime, Date endTime) {
        long between;
        if (startTime != null && endTime != null) {
            LocalDateTime startLocalDateTime = startTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime endLocalDateTime = endTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            between = ChronoUnit.DAYS.between(startLocalDateTime, endLocalDateTime);
        } else {
            between = 0L;
        }
        return between;
    }
}
