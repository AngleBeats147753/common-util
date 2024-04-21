package com.eggcampus.util.exception.result;

import com.eggcampus.util.result.AliErrorCode;
import lombok.Getter;

/**
 * 业务异常
 *
 * @author 黄磊
 * @since 2022/6/24
 **/
@Getter
public class ServiceException extends ReturnResultException {


    public ServiceException(AliErrorCode code, String userTip) {
        super(code, userTip);
    }

    public ServiceException(AliErrorCode code, String userTip, Exception exception) {
        super(code, userTip, exception);
    }

    public ServiceException(AliErrorCode code, String userTip, String errorMessage) {
        super(code, userTip, errorMessage);
    }

    public ServiceException(AliErrorCode code, String userTip, String errorMessage, Exception exception) {
        super(code, userTip, errorMessage, exception);
    }

}
