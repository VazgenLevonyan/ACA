package com.acapro.certificat.transfer.request.applicant;

import lombok.Data;

@Data
public class UpdateApplicantRequest {
    private String email;
    private int phoneNumber;
    private String address;
    private Long  course_id;
}
