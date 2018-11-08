package cn.ly.caotuan.phone.client.security.model;

import cn.ly.system.api.entity.TripUser;

/**
 * The type Auth user factory.
 *
 * @author liuyi
 */
public final class AuthUserFactory {

    private AuthUserFactory() {
    }

    /**
     * Create auth user.
     *
     * @param user the user
     * @return the auth user
     */
    public static AuthUser create(TripUser user) {
        return new AuthUser(
            user.getId(),
            user.getMobile(),
            user.getPassword(),
            user.getEnabled()
        );
    }

}
