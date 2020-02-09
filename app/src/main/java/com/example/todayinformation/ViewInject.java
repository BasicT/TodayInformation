package com.example.todayinformation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by shixi on 2019/6/14.
 */

@Retention(RUNTIME)
@Target(TYPE)
public @interface ViewInject {

    int mainlayoutid() default -1;

}
