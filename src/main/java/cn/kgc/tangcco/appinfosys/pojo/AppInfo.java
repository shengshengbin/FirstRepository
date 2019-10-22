package cn.kgc.tangcco.appinfosys.pojo;

import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Date;

/*app信息*/
@Data
public class AppInfo {
    private Integer id;//主键
    private String softwareName;//软件名称
    private  String APKName;//APK名称(唯一)
    private String supportROM;//支持ROM
    private String interfaceLanguage;//界面语言
    private double softwareSize;//软件大小(单位:M)
    private Date updateDate;//跟新日期
    private  Integer devId;//开发者id（来源于：dev_user表的开发者id）
    private String appInfo;//应用简介
    private Integer status;//状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
    private Date onSaleDate;//上架时间
    private Date offSaleDate;//下架时间
    private Integer flatforId;//所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
    private Integer categoryLevel3;//所属三级分类
    private Integer downloads;//下载量
    private Integer createdBy;//创建者
    private Date creationDate;//创建时间
    private Integer modifyBy;//更新者
    private Date modifyDate;//最新跟新时间
    private Integer categoryLevel1;//所属一级分类
    private Integer categoryLevel2;//所属二级分类
    private String logoPicPath;//LOGO图片url路径
    private String logoLocPath;//LOGO图片的服务器存储
    private Integer versionId;//最新的版本id


    //所属平台的名称
    private String flatformName;
    //所属的123分类
    private String categoryLevel1Name;
    private String categoryLevel2Name;
    private String categoryLevel3Name;
    //所属的状态
    private String statusName;
    //最新版本号
    private String versionNo;





}
