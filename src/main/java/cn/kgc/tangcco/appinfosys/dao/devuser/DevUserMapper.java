package cn.kgc.tangcco.appinfosys.dao.devuser;

import cn.kgc.tangcco.appinfosys.pojo.AppInfo;
import cn.kgc.tangcco.appinfosys.pojo.DevUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface DevUserMapper {
    /**
     * 根据用户编码查询用户
     */
    DevUser getUserByCode(String userCode)throws Exception;




}
