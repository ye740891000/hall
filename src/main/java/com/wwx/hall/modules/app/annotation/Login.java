package com.wwx.hall.modules.app.annotation;

import java.lang.annotation.*;

/**
 * app登录效验
 * @author 王伟欣
 * @email 740891000@qq.com
 * @date 2017/9/23 14:30
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
	String name() default "";
}
