package com.eggcampus.util.exception.result;

import com.eggcampus.util.result.AliErrorCode;

/**
 * 无需日志记录的Manager层异常
 *
 * @author 黄磊
 */
public class NonLoggingManagerException extends ManagerException {
    public NonLoggingManagerException(AliErrorCode code, String userTip) {
        super(code, userTip);
    }

    public NonLoggingManagerException(AliErrorCode code, String userTip, Exception exception) {
        super(code, userTip, exception);
    }

    public NonLoggingManagerException(AliErrorCode code, String userTip, String errorMessage) {
        super(code, userTip, errorMessage);
    }

    public NonLoggingManagerException(AliErrorCode code, String userTip, String errorMessage, Exception exception) {
        super(code, userTip, errorMessage, exception);
    }
}
