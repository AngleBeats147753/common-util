package com.eggcampus.util.exception.database;

/**
 * 乐观锁更新异常
 *
 * @author 黄磊
 */
public class OptimisticLockException extends DatabaseException {

    public OptimisticLockException(String message) {
        super(message);
    }
}
