package cn.kgc.tangcco.appinfosys.dao.appinfo;

import cn.kgc.tangcco.appinfosys.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {



    /*根据软件名称,app状态,所属平台,一级分类,二级分类,三级分类*/
    List<cn.kgc.tangcco.appinfosys.pojo.AppInfo> getSizAppAttr(@Param("softwareName") String softwareName
            , @Param("status") Integer status
            , @Param("flatformId")Integer flatformId
            , @Param("categoryLevel1")Integer categoryLevel1
            , @Param("categoryLevel2")Integer categoryLevel2
            , @Param("categoryLevel3")Integer categoryLevel3
            , @Param("currentPageNo")int currentPageNo
            , @Param("pageSize")int pageSize);

            /*总记录数*/
    public Integer AppInfoCount(@Param("softwareName") String softwareName
            , @Param("status") Integer status
            , @Param("flatformId")Integer flatformId
            , @Param("categoryLevel1")Integer categoryLevel1
            , @Param("categoryLevel2")Integer categoryLevel2
            , @Param("categoryLevel3")Integer categoryLevel3);



    /*查询所有*/
    public List<AppInfo> getAppInfo();

}

