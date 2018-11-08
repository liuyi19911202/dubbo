package cn.ly.system.api.exception;


import cn.ly.system.api.exception.base.BusinessException;

/**
 * 短信发送太频繁
 *
 * @author liuyi
 */
public class SmsTooMuchException extends BusinessException {

    public SmsTooMuchException(String message) {
        super(message);
    }

}
