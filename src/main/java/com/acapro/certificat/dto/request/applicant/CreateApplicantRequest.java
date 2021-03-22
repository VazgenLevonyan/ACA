package com.acapro.certificat.dto.request.applicant;

import com.acapro.certificat.enums.ApplicantStatusType;
import lombok.Data;

@Data
public class CreateApplicantRequest {
    private String name;
    private String email;
    private int phoneNumber;
    private String address;
    private ApplicantStatusType statusType;
    private Long  course_id;
}
