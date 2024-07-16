package com.eggcampus.util.exception.result;

import com.eggcampus.util.result.AliErrorCode;
import com.eggcampus.util.result.ReturnResult;
import lombok.Getter;

/**
 * 业务层异常
 *
 * @author 黄磊
 * @since 2022/6/24
 **/
@Getter
public class ServiceException extends ReturnResultException {


    public ServiceException(AliErrorCode code, String userTip) {
        super(code, userTip);
    }

    public ServiceException(AliErrorCode code, String userTip, String errorMessage) {
        super(code, userTip, errorMessage);
    }

    public ServiceException(AliErrorCode code, String userTip, Throwable exception) {
        super(code, userTip, exception);
    }

    public ServiceException(AliErrorCode code, String userTip, String errorMessage, Throwable exception) {
        super(code, userTip, errorMessage, exception);
    }

    public ServiceException(ReturnResult result) {
        super(result);
    }

    public ServiceException(ReturnResult result, Throwable exception) {
        super(result, exception);
    }
}
