package cn.ly.system.api.exception.base;

/**
 * 业务异常.
 *
 * @author liuyi
 */
public class BusinessException extends Exception {

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

}