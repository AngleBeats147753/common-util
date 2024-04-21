package com.eggcampus.util.exception;

/**
 * 旦晓园基础异常
 *
 * @author 黄磊
 */
public class EggCampusException extends RuntimeException {
    public EggCampusException() {
        super();
    }

    public EggCampusException(String message) {
        super(message);
    }

    public EggCampusException(String message, Throwable cause) {
        super(message, cause);
    }

    public EggCampusException(Throwable cause) {
        super(cause);
    }

    protected EggCampusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
