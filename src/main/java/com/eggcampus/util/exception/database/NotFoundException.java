package com.eggcampus.util.exception.database;

/**
 * 从数据库中找不到指定信息时抛出的异常
 *
 * @author 黄磊
 */
public class NotFoundException extends DatabaseException {

    public NotFoundException(String message) {
        super(message);
    }
}
