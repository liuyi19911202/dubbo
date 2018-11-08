package cn.ly.system.provider.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ly.common.springdata.redis.RedisRepository;
import cn.ly.common.utils.RandomHelper;
import cn.ly.system.api.entity.TripUser;
import cn.ly.system.api.exception.InvalidCaptchaException;
import cn.ly.system.api.exception.UserExistException;
import cn.ly.system.api.exception.UserNotExistException;
import cn.ly.system.api.exception.base.BusinessException;
import cn.ly.system.api.service.ICaptchaService;
import cn.ly.system.api.service.ITripUserService;

/**
 * 验证码服务
 *
 * @author liuyi
 */
@Service
@Transactional(readOnly = true)
public class CaptchaService implements ICaptchaService {

    /**
     * 用户服务
     */
    @Autowired
    private ITripUserService tripUserService;
    /**
     * redis repository
     */
    @Autowired
    private RedisRepository redisRepository;
    /**
     * 缓存前缀
     */
    private static final String REDIS_PREFIX = "captcha_";

    @Override
    public void sendCaptcha4Registry(String mobile) throws BusinessException {
        TripUser user = tripUserService.getByMobile(mobile);
        // 注册,如果用户存在
        if (user != null) {
            throw new UserExistException(String.format("手机号 '%s' 已经注册,直接登录", mobile));
        }

        sendCaptcha(mobile);
    }

    @Override
    public void sendCaptcha4Forget(String mobile) throws BusinessException {
        TripUser user = tripUserService.getByMobile(mobile);
        // 忘记密码,如果用户不存在
        if (user == null) {
            throw new UserNotExistException(String.format(" 手机号 '%s' 未注册", mobile));
        }

        sendCaptcha(mobile);
    }

    @Override
    public void validCaptcha(String mobile, String captcha) throws InvalidCaptchaException {
        String code = redisRepository.get(REDIS_PREFIX + mobile);
        if (!captcha.equals(code)) {
            throw new InvalidCaptchaException(String.format("验证码 '%s' 无效", captcha));
        }
    }

    /**
     * 发送验证码
     *
     * @param mobile 手机号
     * @throws BusinessException the business exception
     */
    private void sendCaptcha(String mobile) throws BusinessException {
        String code = RandomHelper.getRandNum(6); //验证码
        long time = 15L; //15分钟有效期

        //存入 Redis
        redisRepository.setExpire(REDIS_PREFIX + mobile, code, time * 60); //15分钟有效期

        System.out.printf("向 %s 发送短信验证码\n", mobile);
        System.out.printf("您的验证码为：%s，有效期：%s 分钟\n", code, time);
    }
}
