package com.acapro.certificat.exceptions;

public class ApplicantNotFoundException extends RuntimeException{
    public ApplicantNotFoundException(Long id){
        super(String.format("Applicant by id: {%d} does not exist",id));
    }
}
