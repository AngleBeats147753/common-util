package com.eggcampus.util.mybatis.exception;

import com.eggcampus.util.result.AliErrorCode;

/**
 * 乐观锁重试次数超过上限异常
 *
 * @author 黄磊
 */
public class OptimisticLockException extends DatabaseException {

    public OptimisticLockException(String message) {
        super(AliErrorCode.SYSTEM_ERROR_B0001, message);
    }
}
