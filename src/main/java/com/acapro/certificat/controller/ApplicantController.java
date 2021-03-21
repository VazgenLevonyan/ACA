package com.acapro.certificat.controller;

import com.acapro.certificat.api.ApiResponse;
import com.acapro.certificat.entity.Applicant;
import com.acapro.certificat.service.ApplicantService;
import com.acapro.certificat.transfer.request.applicant.CreateApplicantRequest;
import com.acapro.certificat.transfer.request.applicant.UpdateApplicantRequest;
import com.acapro.certificat.transfer.response.applicant.CreateApplicantResponse;
import com.acapro.certificat.transfer.response.applicant.GetApplicantResponse;
import com.acapro.certificat.transfer.response.applicant.UpdateApplicantResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.http.HTTPBinding;
import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping("/add")
    public ApiResponse<CreateApplicantResponse> add(@RequestBody CreateApplicantRequest createApplicantRequest) {
        return new ApiResponse<>("Appliacnt successfully created", HttpStatus.OK.value(), applicantService.add(createApplicantRequest));
    }

    @GetMapping("{id}")
    public ApiResponse<GetApplicantResponse> get(@PathVariable Long id) {
        return new ApiResponse<>(String.format("Applicant  by id: {%d}",id),HttpStatus.CREATED.value(), applicantService.get(id));
    }

    @GetMapping("/all")
    public ApiResponse<List<GetApplicantResponse>> getAll() {
        return new ApiResponse<>("All applicants", HttpStatus.OK.value(), applicantService.getAll());
    }

    @PutMapping("{id}")
    public ApiResponse<UpdateApplicantResponse> update(@RequestBody UpdateApplicantRequest updateApplicantRequest, @PathVariable Long id) {
        return new ApiResponse<>(String.format("Applicant  by id: {%d} successfully updated", id), HttpStatus.OK.value(), applicantService.update(updateApplicantRequest, id));
    }

    @DeleteMapping("{id}")
    public ApiResponse<Void> delete(@PathVariable Long id){
        applicantService.delete(id);
        return new ApiResponse<>(String.format("Applicant by id: {%d} successfully removed", id), HttpStatus.OK.value());
    }

}
