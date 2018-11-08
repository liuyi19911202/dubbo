package cn.ly.system.api.exception;

import cn.ly.system.api.exception.base.BusinessException;

/**
 * 无效验证码
 *
 * @author liuyi
 */
public class InvalidCaptchaException extends BusinessException {

	public InvalidCaptchaException(String message) {
		super(message);
	}

}
