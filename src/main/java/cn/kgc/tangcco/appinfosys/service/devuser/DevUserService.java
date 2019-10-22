package cn.kgc.tangcco.appinfosys.service.devuser;

import cn.kgc.tangcco.appinfosys.pojo.AppInfo;
import cn.kgc.tangcco.appinfosys.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DevUserService {
    /**
     * 登陆
     */
    DevUser login(String userCode,String userPassword)throws Exception;




}
