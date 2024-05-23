package com.eggcampus.util.exception.base;

import com.eggcampus.util.exception.EggCampusException;

/**
 * 断言失败时抛出的异常
 *
 * @author 黄磊
 */
public class AssertionFailedException extends EggCampusException {
    public AssertionFailedException() {
        super();
    }

    public AssertionFailedException(String message) {
        super(message);
    }

    public AssertionFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AssertionFailedException(Throwable cause) {
        super(cause);
    }

    protected AssertionFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
