package cn.kgc.tangcco.appinfosys.service.appinfo;

import cn.kgc.tangcco.appinfosys.dao.appinfo.AppInfoMapper;
import cn.kgc.tangcco.appinfosys.pojo.AppInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AppInfoServiceImpl implements AppInfoService {

    @Resource
    private AppInfoMapper appInfoMapper;

    @Override
    public List<AppInfo> findSizAppAttr(String softwareNaem, Integer status, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3,Integer currentPageNo,Integer pageSize) {
        return appInfoMapper.getSizAppAttr(softwareNaem,status,flatformId,categoryLevel1,categoryLevel2,categoryLevel3,currentPageNo,pageSize);
    }
/*总计录数*/
    @Override
    public Integer AppInfoCount(String softwareNaem, Integer status, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3) {
        return appInfoMapper.AppInfoCount(softwareNaem,status,flatformId,categoryLevel1,categoryLevel2,categoryLevel3);
    }

    @Override
    public List<AppInfo> getAppInfo() {
        return appInfoMapper.getAppInfo();
    }
}
