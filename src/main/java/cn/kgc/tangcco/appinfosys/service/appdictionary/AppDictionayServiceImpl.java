package cn.kgc.tangcco.appinfosys.service.appdictionary;

import cn.kgc.tangcco.appinfosys.dao.appdictionary.AppDictionayMapper;
import cn.kgc.tangcco.appinfosys.pojo.AppDictionary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppDictionayServiceImpl implements AppDictionayService {


    @Resource
    private AppDictionayMapper appDictionayMapper;
    @Override
    public List<AppDictionary> getValueNameByValueId(String typeName) {
        return appDictionayMapper.getValueNameByValueId(typeName);
    }
}
