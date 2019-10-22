package cn.kgc.tangcco.appinfosys.pojo;

import lombok.Data;

import java.util.Date;

//app版本
@Data
public class AppVersion {
    private Integer id;//主键id
    private Integer appId;//appId（来源于：app_info表的主键id）
    private String versionNo;//版本号
    private String versionInfo;//版本介绍
    private Integer publishStatus;//发布状态
    private String downloadLink;//下载链接
    private double versionSize;//版本大小
    private Integer createdBy;//创建者
    private Date creationDate;//创建时间
    private Integer modifyBy;//跟新者
    private Date modifyDate;//最新跟新时间
    private String apkLocPath;//apk文件的服务器存储
    private String apkFileName;//上传的apk文件名称

}
