package cn.ly.caotuan.phone.client.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.ly.caotuan.phone.client.security.model.AuthUserFactory;
import cn.ly.system.api.entity.TripUser;
import cn.ly.system.api.service.ITripUserService;

/**
 * Security User Detail Service
 *
 * @author liuyi
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * 用户服务
     */
    @Autowired
    private ITripUserService tripUserService;

    @Override
    public UserDetails loadUserByUsername(String loginName) {
        TripUser user = tripUserService.getByMobile(loginName);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", loginName));
        } else {
            return AuthUserFactory.create(user);
        }
    }
}
