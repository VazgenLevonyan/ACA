package com.acapro.certificat.exception;

public class CourseNotFoundException extends  RuntimeException{
    public CourseNotFoundException(Long id){
        super(String.format("Course by id: {%d} does not exist",id));
    }
}