package com.eggcampus.util.exception.result;

import com.eggcampus.util.exception.EggcampusException;
import com.eggcampus.util.result.AliErrorCode;
import lombok.Getter;

/**
 * 返回给客户端的异常，带有各种提示信息
 *
 * @author 黄磊
 */
@Getter
public class ReturnResultException extends EggcampusException {
    private final AliErrorCode code;
    private final String userTip;
    private final String errorMessage;

    public ReturnResultException(AliErrorCode code, String userTip) {
        super(code.getCode() + userTip);
        this.code = code;
        this.userTip = userTip;
        this.errorMessage = null;
    }

    public ReturnResultException(AliErrorCode code, String userTip, String errorMessage) {
        super(code.getCode() + errorMessage);
        this.code = code;
        this.userTip = userTip;
        this.errorMessage = errorMessage;
    }

    public ReturnResultException(AliErrorCode code, String userTip, Throwable exception) {
        super(code.getCode() + userTip, exception);
        this.code = code;
        this.userTip = userTip;
        this.errorMessage = null;
    }

    public ReturnResultException(AliErrorCode code, String userTip, String errorMessage, Throwable exception) {
        super(code.getCode() + errorMessage, exception);
        this.code = code;
        this.userTip = userTip;
        this.errorMessage = errorMessage;
    }

    public String getStringCode() {
        return this.code.getCode();
    }

}
