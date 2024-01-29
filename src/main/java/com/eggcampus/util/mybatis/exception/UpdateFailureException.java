package com.eggcampus.util.mybatis.exception;

import com.eggcampus.util.result.AliErrorCode;

/**
 * 数据库更新失败异常
 * <p>
 * 在更新以前通常已经校验过参数的正确性，如果更新失败，通常是由于系统原因，而非用户原因
 * </p>
 *
 * @author 黄磊
 */
public class UpdateFailureException extends DatabaseException {

    public UpdateFailureException(String message) {
        super(AliErrorCode.SYSTEM_ERROR_B0001, message);
    }
}
