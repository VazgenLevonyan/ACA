package com.acapro.certificat.transfer.response.applicant;

import lombok.Data;

@Data
public class UpdateApplicantResponse {
    private String email;
    private int phoneNumber;
    private String address;

}
