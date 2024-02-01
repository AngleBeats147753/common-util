package com.eggcampus.util.spring.log;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 接口中文名
     */
    String value() default "";
}
