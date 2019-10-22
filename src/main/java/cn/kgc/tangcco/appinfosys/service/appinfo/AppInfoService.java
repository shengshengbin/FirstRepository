package cn.kgc.tangcco.appinfosys.service.appinfo;

import cn.kgc.tangcco.appinfosys.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoService {
    /*根据软件名称,app状态,所属平台,一级分类,二级分类,三级分类*/
    List<AppInfo> findSizAppAttr(String softwareName, Integer status , Integer flatformId, Integer categoryLevel1, Integer categoryLevel2 , Integer categoryLevel3,Integer currentPageNo,Integer pageSize);




    /*总记录数*/
    public Integer AppInfoCount(String softwareName, Integer status ,Integer flatformId, Integer categoryLevel1,Integer categoryLevel2,Integer categoryLevel3);



    /*查询所有*/
    public List<AppInfo> getAppInfo();
}
