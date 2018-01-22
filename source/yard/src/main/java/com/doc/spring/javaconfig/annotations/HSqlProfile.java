package com.doc.spring.javaconfig.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Profile;

import com.doc.spring.config.ConfigConstants;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Profile(ConfigConstants.HSQL_PROFILE)
public @interface HSqlProfile {

}
