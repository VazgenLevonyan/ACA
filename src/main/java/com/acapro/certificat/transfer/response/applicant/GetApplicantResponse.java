package com.acapro.certificat.transfer.response.applicant;

import lombok.Data;

@Data
public class GetApplicantResponse {
    private Long id;
    private String name;
    private String email;
    private int phoneNumber;
    private String address;

}
