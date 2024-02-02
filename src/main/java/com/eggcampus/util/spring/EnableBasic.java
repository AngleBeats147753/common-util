package com.eggcampus.util.spring;

import com.eggcampus.util.spring.application.EnableApplicationManager;
import com.eggcampus.util.spring.exception.EnableExceptionHandler;
import com.eggcampus.util.spring.log.EnableLog;

import java.lang.annotation.*;

/**
 * @author 黄磊
 */
@EnableLog
@EnableExceptionHandler
@EnableApplicationManager
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface EnableBasic {
}
