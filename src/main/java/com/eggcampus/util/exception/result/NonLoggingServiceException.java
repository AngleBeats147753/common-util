package com.eggcampus.util.exception.result;

import com.eggcampus.util.result.AliErrorCode;

/**
 * 无需日志记录的Service层异常
 *
 * @author 黄磊
 */
public class NonLoggingServiceException extends ServiceException {
    public NonLoggingServiceException(AliErrorCode code, String userTip) {
        super(code, userTip);
    }

    public NonLoggingServiceException(AliErrorCode code, String userTip, Exception exception) {
        super(code, userTip, exception);
    }

    public NonLoggingServiceException(AliErrorCode code, String userTip, String errorMessage) {
        super(code, userTip, errorMessage);
    }

    public NonLoggingServiceException(AliErrorCode code, String userTip, String errorMessage, Exception exception) {
        super(code, userTip, errorMessage, exception);
    }
}
