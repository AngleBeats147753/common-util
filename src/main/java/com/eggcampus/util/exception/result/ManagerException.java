package com.eggcampus.util.exception.result;

import com.eggcampus.util.result.AliErrorCode;
import com.eggcampus.util.result.ReturnResult;
import lombok.Getter;

/**
 * Manager层异常
 *
 * @author 黄磊
 * @since 2022/6/24
 **/
@Getter
public class ManagerException extends ReturnResultException {


    public ManagerException(AliErrorCode code, String userTip) {
        super(code, userTip);
    }

    public ManagerException(AliErrorCode code, String userTip, String errorMessage) {
        super(code, userTip, errorMessage);
    }

    public ManagerException(AliErrorCode code, String userTip, Throwable exception) {
        super(code, userTip, exception);
    }

    public ManagerException(AliErrorCode code, String userTip, String errorMessage, Throwable exception) {
        super(code, userTip, errorMessage, exception);
    }

    public ManagerException(ReturnResult result) {
        super(result);
    }

    public ManagerException(ReturnResult result, Throwable exception) {
        super(result, exception);
    }
}
