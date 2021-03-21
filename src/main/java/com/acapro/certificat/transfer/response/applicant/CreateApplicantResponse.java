package com.acapro.certificat.transfer.response.applicant;

import com.acapro.certificat.enums.StatusType;
import lombok.Data;

@Data
public class CreateApplicantResponse {
    private Long id;
    private String name;
    private String email;
    private int phoneNumber;
    private String address;
    private StatusType statusType;

}
