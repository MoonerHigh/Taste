package com.moonerhigh.framework.mybatis.core.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author zpLone
 * @Date 2023/4/13 16:28
 * @PackageName:com.moonerhigh.taste.server.config
 * @ClassName: MyBatisPlusAutoFill
 * @Description: create_time和update_time自动填充
 * @Version 1.0
 */
@Component
public class DefaultDBFieldHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (this.getFieldValByName("createTime", metaObject) == null) {
            this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}
