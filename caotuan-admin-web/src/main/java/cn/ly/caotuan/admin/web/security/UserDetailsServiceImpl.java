package cn.ly.caotuan.admin.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.ly.caotuan.admin.web.security.model.AuthUserFactory;
import cn.ly.system.api.entity.SysUser;
import cn.ly.system.api.service.ISystemService;

/**
 * 自定义Security User Detail Service
 * @ClassName: UserDetailsServiceImpl
 * @author liuyi
 * @date 2018年8月13日
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    /**
     * 系统服务
     */
    @Autowired
    private ISystemService systemService;

    @Override
    public UserDetails loadUserByUsername(String loginName) {
        SysUser user = systemService.getUserByLoginName(loginName);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", loginName));
        } else {
            return AuthUserFactory.create(user);
        }
    }
}
