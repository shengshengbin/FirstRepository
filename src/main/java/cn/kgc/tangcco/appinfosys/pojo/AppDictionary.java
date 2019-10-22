package cn.kgc.tangcco.appinfosys.pojo;

import lombok.Data;

import java.util.Date;

//数据字典
@Data
public class AppDictionary {
    private Integer id;//c主键id
    private String typeCode;//类型编码
    private String typeName;//类型名称
    private Integer valueId;//类型值id

    private String valueName;//类型值Name
    private String createdBy;//创建者
    private Date creationDate;//创建时间
    private Integer modifyBy;//跟新者
    private Date modifyDate;//最新跟新时间
}
