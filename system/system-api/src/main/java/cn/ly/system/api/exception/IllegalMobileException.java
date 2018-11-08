package cn.ly.system.api.exception;


import cn.ly.system.api.exception.base.BusinessException;

/**
 * 手机号码不合法
 *
 * @author liuyi
 */
public class IllegalMobileException extends BusinessException {

    public IllegalMobileException(String message) {
        super(message);
    }

}
