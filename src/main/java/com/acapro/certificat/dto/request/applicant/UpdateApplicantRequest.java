package com.acapro.certificat.dto.request.applicant;

import lombok.Data;

@Data
public class UpdateApplicantRequest {
    private String email;
    private int phoneNumber;
    private String address;
    private Long  course_id;
}
