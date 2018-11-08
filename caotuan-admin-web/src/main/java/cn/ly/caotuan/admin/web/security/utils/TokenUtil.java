package cn.ly.caotuan.admin.web.security.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import cn.ly.caotuan.admin.web.security.model.AuthUser;
import cn.ly.common.web.security.AbstractTokenUtil;

/**
 * token工具
 * @ClassName: TokenUtil
 * @author liuyi
 * @date 2018年8月13日
 */
@Component
@ConfigurationProperties("security.jwt")
public class TokenUtil extends AbstractTokenUtil {

    @Override
    public UserDetails getUserDetails(String token) {
        String userDetailsString = getUserDetailsString(token);
        if (userDetailsString != null) {
            return new Gson().fromJson(userDetailsString, AuthUser.class);
        }
        return null;
    }

}