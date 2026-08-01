package com.tutorials.advanced.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// RUNTIME retention is what makes this annotation discoverable via
// reflection at runtime — SOURCE or CLASS retention would make it invisible
// to code running in the JVM (SOURCE doesn't even survive to the .class file).
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Loggable {
    String value() default "";
}
