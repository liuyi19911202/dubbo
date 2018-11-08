package cn.ly.system.api.exception;


import cn.ly.system.api.exception.base.BusinessException;

/**
 * 用户未存在
 *
 * @author liuyi
 */
public class UserNotExistException extends BusinessException {

    public UserNotExistException(String message) {
        super(message);
    }

}
