package com.chukurs.springdemo.mvc.validation;

import com.chukurs.springdemo.mvc.CourseCodeConstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)//how long annotation will be used and stored in bytecode
public @interface CourseCode {
    //set default value
    public String value() default "CHU";

    //set default message
    public String message() default "must start with CHU";

    //define default groups
    public Class<?>[] groups() default {};

    //define default payloads
    public Class<? extends Payload>[] payload() default {};
}