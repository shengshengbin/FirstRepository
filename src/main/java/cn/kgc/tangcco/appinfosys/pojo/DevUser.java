package cn.kgc.tangcco.appinfosys.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 开发者
 */
@Data
public class DevUser {
    private Integer id;//主键
    private String devCode;//开发者账号
    private String devName;//开发者名称
    private String devPassword;//开发者密码
    private String devEmail;//开发者邮箱
    private String devInfo;//开发者简介
    private String createdBy;//创建者(来源于backend_user用户表的用户id)
    private Date creationDate;//创建时间
    private Integer modifyBy;//更新者(来源于backend_user用户表的用户id)
    private Date modifyDate;//最新跟新时间


}
