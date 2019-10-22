package cn.kgc.tangcco.appinfosys.service.appcategory;

import cn.kgc.tangcco.appinfosys.dao.appcategory.AppCategoryMapper;
import cn.kgc.tangcco.appinfosys.pojo.AppCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AppCategoryServiceImpl implements AppCategoryService {

    @Resource
    private AppCategoryMapper appCategoryMapper;
    @Override
    public List<AppCategory> findCategoryNameById() {
        return appCategoryMapper.getCategoryNameById();
    }

    @Override
    public List<AppCategory> findCategoryNameByparentId(Integer parentId) {
        return appCategoryMapper.getCategoryNameByparentId(parentId);
    }
}
