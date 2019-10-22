package cn.kgc.tangcco.appinfosys.service.devuser;

import cn.kgc.tangcco.appinfosys.dao.devuser.DevUserMapper;
import cn.kgc.tangcco.appinfosys.pojo.AppInfo;
import cn.kgc.tangcco.appinfosys.pojo.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DevUserServiceImpl implements DevUserService {
    @Resource
    private DevUserMapper devUserMapper;
    /**
     * 登陆
     *
     * @param userCode
     * @param userPassword
     */
    @Override
    public DevUser login(String userCode, String userPassword) throws Exception {
        DevUser devUser = devUserMapper.getUserByCode(userCode);
        if (devUser != null){
        if (!devUser.getDevPassword().equals(userPassword)){
                devUser = null;
            }
        }
        return devUser;
    }


}
