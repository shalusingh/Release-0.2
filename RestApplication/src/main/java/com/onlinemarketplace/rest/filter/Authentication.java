/**
 *
 */
package com.onlinemarketplace.rest.filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.onlinemarketplace.dataentity.enums.Right;

/**
 * @author jitendra Dec 23, 2015 2015
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authentication {

    public Right right() default Right.NONE;
}
