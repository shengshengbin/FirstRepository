package cn.kgc.tangcco.appinfosys.service.appcategory;

import cn.kgc.tangcco.appinfosys.pojo.AppCategory;

import java.util.List;

public interface AppCategoryService {
    //    根据id查询分类名称
    public List<AppCategory> findCategoryNameById();


    //根据父级id查询所有分类名称
    public List<AppCategory> findCategoryNameByparentId(Integer parentId);

}
