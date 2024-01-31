package com.eggcampus.util.spring.mybatisplus;

import com.eggcampus.util.spring.mybatisplus.exception.MybatisPlusExceptionHandlerController;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 黄磊
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({MybatisPlusExceptionHandlerController.class})
public @interface EnableMybatisPlus {
}
