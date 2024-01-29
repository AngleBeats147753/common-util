package com.eggcampus.util.mybatis.exception;

import com.eggcampus.util.result.AliErrorCode;

/**
 * 未找到数据异常
 * <p>
 * 常用于findXxx方法，当根据条件不到数据时抛出此异常。此错误通常是由于前端传入的参数错误导致的。
 * </p>
 *
 * @author 黄磊
 */
public class NotFoundException extends DatabaseException {

    public NotFoundException(String message) {
        super(AliErrorCode.USER_ERROR_A0402, message);
    }

    public NotFoundException(AliErrorCode errorCode, String message) {
        super(AliErrorCode.USER_ERROR_A0402, message);
    }
}