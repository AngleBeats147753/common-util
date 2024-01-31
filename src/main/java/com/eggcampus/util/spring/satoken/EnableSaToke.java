package com.eggcampus.util.spring.satoken;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 黄磊
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({SaTokenExceptionHandlerController.class})
public @interface EnableSaToke {
}
