package com.eggcampus.util.exception;

/**
 * 旦晓园基础异常
 *
 * @author 黄磊
 */
public class EggcampusException extends RuntimeException {
    public EggcampusException() {
        super();
    }

    public EggcampusException(String message) {
        super(message);
    }

    public EggcampusException(String message, Throwable cause) {
        super(message, cause);
    }

    public EggcampusException(Throwable cause) {
        super(cause);
    }

    protected EggcampusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
