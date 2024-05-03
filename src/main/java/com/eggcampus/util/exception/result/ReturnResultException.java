package com.eggcampus.util.exception.result;

import com.eggcampus.util.exception.EggCampusException;
import com.eggcampus.util.result.AliErrorCode;
import com.eggcampus.util.result.ReturnResult;
import lombok.Getter;

/**
 * 返回给客户端的异常，带有各种提示信息
 *
 * @author 黄磊
 */
@Getter
public class ReturnResultException extends EggCampusException {
    private static final String ERROR_MESSAGE = "错误码<%s>，用户提示信息<%s>，错误提示信息<%s>";
    private final AliErrorCode code;
    private final String userTip;
    private final String errorMessage;

    public ReturnResultException(AliErrorCode code, String userTip) {
        super(ERROR_MESSAGE.formatted(code.getCode(), userTip, null));
        this.code = code;
        this.userTip = userTip;
        this.errorMessage = null;
    }

    public ReturnResultException(AliErrorCode code, String userTip, String errorMessage) {
        super(errorMessage.formatted(code.getCode(), userTip, errorMessage));
        this.code = code;
        this.userTip = userTip;
        this.errorMessage = errorMessage;
    }

    public ReturnResultException(AliErrorCode code, String userTip, Throwable exception) {
        super(ERROR_MESSAGE.formatted(code.getCode(), userTip, null), exception);
        this.code = code;
        this.userTip = userTip;
        this.errorMessage = null;
    }

    public ReturnResultException(AliErrorCode code, String userTip, String errorMessage, Throwable exception) {
        super(errorMessage.formatted(code.getCode(), userTip, errorMessage), exception);
        this.code = code;
        this.userTip = userTip;
        this.errorMessage = errorMessage;
    }

    public ReturnResultException(ReturnResult result) {
        super(ERROR_MESSAGE.formatted(result.getStatus(), result.getMessage(), result.getErrorMessage()));
        this.code = result.getStatus();
        this.userTip = result.getMessage();
        this.errorMessage = result.getErrorMessage();
    }

    public ReturnResultException(ReturnResult result, Throwable exception) {
        super(ERROR_MESSAGE.formatted(result.getStatus(), result.getMessage(), result.getErrorMessage()), exception);
        this.code = result.getStatus();
        this.userTip = result.getMessage();
        this.errorMessage = result.getErrorMessage();
    }

    public String getStringCode() {
        return this.code.getCode();
    }

}
