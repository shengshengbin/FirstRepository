package cn.kgc.tangcco.appinfosys.pojo;

import lombok.Data;

import java.util.Date;

/*后台管理*/
@Data
public class BackendUser {
    private Integer id;//主键id
    private  String userCode;//用户编码
    private String userName;//用户名称
    private Integer userType;//用户角色类型
    private Integer createdBy;//创建者
    private Date creationDate;//创建时间
    private Integer modifyBy;//更新者
    private Date modifyDate;//最新跟新时间
    private String userPassword;//用户密码

}
