package com.mmall.exception;

/**
 * @Description: PermissonException
 * @Author: WuZhenYu
 * @CreateDate: 2019/7/3 23:08
 */
public class PermissonException extends RuntimeException {
    public PermissonException(String msg) {
        super(msg);
    }

    public PermissonException() {
        super();
    }

    public PermissonException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissonException(Throwable cause) {
        super(cause);
    }

    protected PermissonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
