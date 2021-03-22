package com.acapro.certificat.dto.response.applicant;

import com.acapro.certificat.entity.Course;
import com.acapro.certificat.enums.ApplicantStatusType;
import lombok.Data;

@Data
public class CreateApplicantResponse {
    private Long id;
    private String name;
    private String email;
    private int phoneNumber;
    private String address;
    private ApplicantStatusType statusType;
    private Course course;

}
