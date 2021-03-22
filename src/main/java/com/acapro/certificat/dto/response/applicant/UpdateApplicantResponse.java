package com.acapro.certificat.dto.response.applicant;
import com.acapro.certificat.entity.Course;
import lombok.Data;

@Data
public class UpdateApplicantResponse {
    private String email;
    private int phoneNumber;
    private String address;
    private Course course;
}
