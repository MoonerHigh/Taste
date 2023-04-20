package com.moonerhigh.framework.spider.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * (SpiderStateGrid)表实体类
 *
 * @author zpLone
 * @since 2023-04-20 13:32:46
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
public class SpiderStateGrid extends Model<SpiderStateGrid> {
    //主键ID
    private Long id;
    //文章链接
    private String articleUrl;
    //文章标题
    private String title;
    //文章内容
    private String notice;
    //发布日期
    private String releaseDate;
    //文章来源
    private String author;
    //公司地址
    private String companyAddr;
    //图片名称
    private String imageName;
    //图片链接
    private String imageUrl;
    //文件名称
    private String fileName;
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
    private LocalDateTime createTime;
    //更新日期
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
    //删除标志 （0未删除 1已删除）
    private String deleted;
    //备注
    private String remark;

}

