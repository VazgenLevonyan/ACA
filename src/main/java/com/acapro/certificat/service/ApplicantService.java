package com.acapro.certificat.service;

import com.acapro.certificat.exception.ApplicantNotFoundException;
import com.acapro.certificat.exception.CourseNotFoundException;
import com.acapro.certificat.entity.Applicant;
import com.acapro.certificat.repository.ApplicantRepository;
import com.acapro.certificat.repository.CourseRepository;
import com.acapro.certificat.entity.Course;
import com.acapro.certificat.dto.request.applicant.CreateApplicantRequest;
import com.acapro.certificat.dto.request.applicant.UpdateApplicantRequest;
import com.acapro.certificat.dto.response.applicant.CreateApplicantResponse;
import com.acapro.certificat.dto.response.applicant.GetApplicantResponse;
import com.acapro.certificat.dto.response.applicant.UpdateApplicantResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final CourseRepository courseRepository;

    public ApplicantService(ApplicantRepository applicantRepository, CourseRepository courseRepository) {
        this.applicantRepository = applicantRepository;
        this.courseRepository = courseRepository;
    }

    public CreateApplicantResponse createApplicant(CreateApplicantRequest createApplicantRequest) {
        Applicant applicant = new Applicant();
        BeanUtils.copyProperties(createApplicantRequest, applicant);
        Course course = courseRepository.findById(createApplicantRequest.getCourse_id()).orElseThrow(() -> new CourseNotFoundException(createApplicantRequest.getCourse_id()));
        applicant.setCourse(course);
        CreateApplicantResponse createApplicantResponse = new CreateApplicantResponse();

        Applicant save = applicantRepository.save(applicant);
        BeanUtils.copyProperties(save, createApplicantResponse);
        return createApplicantResponse;
    }

    public GetApplicantResponse getApplicant(Long id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ApplicantNotFoundException(id));
        GetApplicantResponse getApplicantResponse = new GetApplicantResponse();
        BeanUtils.copyProperties(applicant, getApplicantResponse);
        return getApplicantResponse;
    }

    public List<GetApplicantResponse> getAllApplicants() {
        List<GetApplicantResponse> getApplicantResponseList = new ArrayList<>();
        List<Applicant> applicantList = applicantRepository.findAll();
        for (Applicant applicant : applicantList) {
            GetApplicantResponse getApplicantResponse = new GetApplicantResponse();
            BeanUtils.copyProperties(applicant, getApplicantResponse);
            getApplicantResponseList.add(getApplicantResponse);
        }
        return getApplicantResponseList;
    }

    public UpdateApplicantResponse updateApplicant(UpdateApplicantRequest updateApplicantRequest, Long id) {
        UpdateApplicantResponse updateApplicantResponse = new UpdateApplicantResponse();
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ApplicantNotFoundException(id));
        BeanUtils.copyProperties(updateApplicantRequest, applicant);
        Course course = courseRepository.findById(updateApplicantRequest.getCourse_id()).orElseThrow(() -> new CourseNotFoundException(updateApplicantRequest.getCourse_id()));
        applicant.setCourse(course);
        Applicant saved = applicantRepository.save(applicant);
        BeanUtils.copyProperties(saved, updateApplicantResponse);
        return updateApplicantResponse;
    }

    public void deleteApplicant(Long id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ApplicantNotFoundException(id));
        applicantRepository.delete(applicant);
    }
}
