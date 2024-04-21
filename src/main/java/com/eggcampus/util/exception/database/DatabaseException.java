package com.eggcampus.util.exception.database;

import com.eggcampus.util.exception.EggcampusException;

/**
 * 数据库异常
 *
 * @author 黄磊
 */
public class DatabaseException extends EggcampusException {

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(Throwable cause) {
        super(cause);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
