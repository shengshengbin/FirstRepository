package cn.kgc.tangcco.appinfosys.dao.appcategory;

import cn.kgc.tangcco.appinfosys.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppCategoryMapper {

//    根据id查询分类名称
    public List<AppCategory> getCategoryNameById();


    //根据父级id查询所有分类名称
    public List<AppCategory> getCategoryNameByparentId(@Param("parentId") Integer parentId);


}
