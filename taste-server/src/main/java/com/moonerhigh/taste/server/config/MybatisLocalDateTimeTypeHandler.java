package com.moonerhigh.taste.server.config;

import org.apache.ibatis.type.LocalDateTimeTypeHandler;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @Author zpLone
 * @Date 2023/4/20 1:41
 * @PackageName:com.moonerhigh.taste.server.config
 * @ClassName: MybatisLocalDateTimeTypeHandler
 * @Description: 实体日期类型localDateTime兼容
 * @Version 1.0
 */
@Component
public class MybatisLocalDateTimeTypeHandler extends LocalDateTimeTypeHandler {

    @Override
    public LocalDateTime getResult(ResultSet rs, String columnName) throws SQLException {
        Object object = rs.getObject(columnName);
        if (object == null) {
            return null;
        }
        if (object instanceof Timestamp) {
            return ((Timestamp) object).toLocalDateTime();
        }
        return super.getResult(rs, columnName);
    }

}
