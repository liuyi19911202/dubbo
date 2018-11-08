package cn.ly.system.api.exception;


import cn.ly.system.api.exception.base.BusinessException;

/**
 * 用户已存在
 *
 * @author liuyi
 */
public class UserExistException extends BusinessException {

    public UserExistException(String message) {
        super(message);
    }

}
