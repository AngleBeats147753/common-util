package com.eggcampus.util.exception.result;

import com.eggcampus.util.result.AliErrorCode;
import lombok.Getter;

/**
 * 使用OpenFeign时抛出的异常
 *
 * @author 黄磊
 */
@Getter
public class FeignException extends ReturnResultException {
    public FeignException(AliErrorCode code, String userTip) {
        super(code, userTip);
    }

    public FeignException(AliErrorCode code, String userTip, String errorMessage) {
        super(code, userTip, errorMessage);
    }

    public FeignException(AliErrorCode code, String userTip, Throwable exception) {
        super(code, userTip, exception);
    }

    public FeignException(AliErrorCode code, String userTip, String errorMessage, Throwable exception) {
        super(code, userTip, errorMessage, exception);
    }
}
