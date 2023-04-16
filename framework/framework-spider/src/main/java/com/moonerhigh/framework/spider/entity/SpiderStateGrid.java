package com.moonerhigh.framework.spider.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (SpiderStateGrid)表实体类
 *
 * @author zpLone
 * @since 2023-04-16 17:56:23
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class SpiderStateGrid extends Model<SpiderStateGrid> {
    //主键ID
    private Long id;
    //文章链接
    private String articleUrl;
    //发布日期
    private String releaseDate;
    //文章来源
    private String infoSources;
    //公司地址
    private String companyAddr;
    //图片链接
    private String pictureUrl;
    //文件地址
    private String fileUrl;
    //邮箱
    private String mail;
    //传真
    private String faxNo;
    //联系电话
    private String phoneNo;
    //添加日期
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //更新日期
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
    //删除标志
    private String deleted;
    //备注
    private String remark;
}

