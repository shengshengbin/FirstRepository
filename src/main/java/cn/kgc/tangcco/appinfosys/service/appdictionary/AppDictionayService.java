package cn.kgc.tangcco.appinfosys.service.appdictionary;

import cn.kgc.tangcco.appinfosys.pojo.AppDictionary;

import java.util.List;

public interface AppDictionayService {
    //    根据类型值id查询类型名称
    public List<AppDictionary> getValueNameByValueId(String typeName);
}
