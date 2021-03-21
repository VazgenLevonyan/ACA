package com.acapro.certificat.transfer.request.applicant;

import com.acapro.certificat.enums.StatusType;
import lombok.Data;

@Data
public class CreateApplicantRequest {
    private String name;
    private String email;
    private int phoneNumber;
    private String address;
    private StatusType statusType;
    private Long  course_id;
}
