package com.eggcampus.util.exception;

import com.eggcampus.util.result.AliErrorCode;
import lombok.Getter;

/**
 * @author 黄磊
 */
@Getter
public class EggCampusException extends RuntimeException {
    private final AliErrorCode code;
    private final String userTip;
    private final String errorMessage;

    public EggCampusException(AliErrorCode code, String userTip) {
        super(code.getCode() + userTip);
        this.code = code;
        this.userTip = userTip;
        this.errorMessage = null;
    }

    public EggCampusException(AliErrorCode code, String userTip, String errorMessage) {
        super(code.getCode() + errorMessage);
        this.code = code;
        this.userTip = userTip;
        this.errorMessage = errorMessage;
    }

    public EggCampusException(AliErrorCode code, String userTip, Throwable exception) {
        super(code.getCode() + userTip, exception);
        this.code = code;
        this.userTip = userTip;
        this.errorMessage = null;
    }

    public EggCampusException(AliErrorCode code, String userTip, String errorMessage, Throwable exception) {
        super(code.getCode() + errorMessage, exception);
        this.code = code;
        this.userTip = userTip;
        this.errorMessage = errorMessage;
    }

    public String getStringCode() {
        return this.code.getCode();
    }

}
