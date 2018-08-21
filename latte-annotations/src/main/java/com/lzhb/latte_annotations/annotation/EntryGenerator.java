package com.lzhb.latte_annotations.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author: Lzhb
 * created on: 2018/8/21 9:56
 * description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface EntryGenerator {
    String packageName();
    Class<?> entryTemplete();
}
