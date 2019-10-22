package cn.kgc.tangcco.appinfosys.pojo;

import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Date;

/**
 * app的类别
 */
@Data
public class AppCategory {
    private Integer id;//主键id
    private String categoryCode;//分类编码
    private String categoryName;//分类名称
    private Integer parentId;//父级节点id
    private Integer createdBy;//创建者（来源于backend_user用户表的用户id）
    private Date creationTime;//创建时间
    private Integer modifyBy;//更新者（来源于backend_user用户表的用户id）
    private Date modifyDate;//最新跟新时间
}
