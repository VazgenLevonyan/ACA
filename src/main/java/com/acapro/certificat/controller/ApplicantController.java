package com.acapro.certificat.controller;

import com.acapro.certificat.api.ApiResponse;
import com.acapro.certificat.service.ApplicantService;
import com.acapro.certificat.dto.request.applicant.CreateApplicantRequest;
import com.acapro.certificat.dto.request.applicant.UpdateApplicantRequest;
import com.acapro.certificat.dto.response.applicant.CreateApplicantResponse;
import com.acapro.certificat.dto.response.applicant.GetApplicantResponse;
import com.acapro.certificat.dto.response.applicant.UpdateApplicantResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping("/add")
    public ApiResponse<CreateApplicantResponse> createApplicant(@RequestBody CreateApplicantRequest createApplicantRequest) {
        return new ApiResponse<>("Appliacnt successfully created", HttpStatus.OK.value(), applicantService.createApplicant(createApplicantRequest));
    }

    @GetMapping("{id}")
    public ApiResponse<GetApplicantResponse> getApplicant(@PathVariable Long id) {
        return new ApiResponse<>(String.format("Applicant  by id: {%d}", id), HttpStatus.CREATED.value(), applicantService.getApplicant(id));
    }

    @GetMapping("/all")
    public ApiResponse<List<GetApplicantResponse>> getAllApplicants() {
        return new ApiResponse<>("All applicants", HttpStatus.OK.value(), applicantService.getAllApplicants());
    }

    @PutMapping("{id}")
    public ApiResponse<UpdateApplicantResponse> updateApplicant(@RequestBody UpdateApplicantRequest updateApplicantRequest, @PathVariable Long id) {
        return new ApiResponse<>(String.format("Applicant  by id: {%d} successfully updated", id), HttpStatus.OK.value(), applicantService.updateApplicant(updateApplicantRequest, id));
    }

    @DeleteMapping("{id}")
    public ApiResponse<Void> deleteApplicant(@PathVariable Long id) {
        applicantService.deleteApplicant(id);
        return new ApiResponse<>(String.format("Applicant by id: {%d} successfully removed", id), HttpStatus.OK.value());
    }
}
