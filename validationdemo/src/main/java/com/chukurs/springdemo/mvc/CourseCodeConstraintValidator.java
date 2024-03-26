package com.chukurs.springdemo.mvc;

import com.chukurs.springdemo.mvc.validation.CourseCode;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    private String coursePrefix;//this is what it validated against

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();//access that value="" from @CourseCode, this makes it dynamic

    }

    //spring mvc will call this isValid()
    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        //theCode is what user entered in form
        boolean result;
        if (theCode != null) {
            result = theCode.startsWith(coursePrefix);
        } else {

            result = true;
        }
        return result;
    }
}
