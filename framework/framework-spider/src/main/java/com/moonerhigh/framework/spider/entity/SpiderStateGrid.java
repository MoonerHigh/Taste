package com.moonerhigh.framework.spider.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * (SpiderStateGrid)表实体类
 *
 * @author zpLone
 * @since 2023-04-18 13:32:15
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
    // 正文
    private String articleContent;
    //发布日期
    private String releaseDate;
    //文章来源
    private String infoSources;
    //公司地址
    private String companyAddr;
    //图片链接
    private String imageUrl;
    //文件地址
    private String fileUrl;
    //邮箱
    private String mail;
    //传真
    private String faxNo;
    //联系电话
    private String phoneNo;
    //添加日期
    private Date createTime;
    //更新日期
    private Date updateTime;
    //删除标志 （0未删除 1已删除）
    private String deleted;
    //备注
    private String remark;

}

