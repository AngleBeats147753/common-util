package com.eggcampus.util.mybatis.exception;

import com.eggcampus.util.exception.EggCampusException;
import com.eggcampus.util.result.AliErrorCode;

/**
 * @author 黄磊
 */
public class DatabaseException extends EggCampusException {

    public DatabaseException(String errorMessage) {
        super(AliErrorCode.SYSTEM_ERROR_B0001, errorMessage, errorMessage);
    }

    public DatabaseException(String errorMessage, Throwable cause) {
        super(AliErrorCode.SYSTEM_ERROR_B0001, errorMessage, errorMessage, cause);
    }

    public DatabaseException(AliErrorCode errorCode, String errorMessage) {
        super(errorCode, errorMessage, errorMessage);
    }

    public DatabaseException(AliErrorCode errorCode, String errorMessage, Throwable cause) {
        super(errorCode, errorMessage, errorMessage, cause);
    }
}
