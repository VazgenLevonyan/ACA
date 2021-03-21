package com.acapro.certificat.service;

import com.acapro.certificat.enums.StatusType;
import com.acapro.certificat.exceptions.ApplicantNotFoundException;
import com.acapro.certificat.exceptions.CourseNotFoundException;
import com.acapro.certificat.entity.Applicant;
import com.acapro.certificat.repository.ApplicantRepository;
import com.acapro.certificat.repository.CourseRepository;
import com.acapro.certificat.entity.Course;
import com.acapro.certificat.transfer.request.applicant.CreateApplicantRequest;
import com.acapro.certificat.transfer.request.applicant.UpdateApplicantRequest;
import com.acapro.certificat.transfer.response.applicant.CreateApplicantResponse;
import com.acapro.certificat.transfer.response.applicant.GetApplicantResponse;
import com.acapro.certificat.transfer.response.applicant.UpdateApplicantResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService implements AddSupported<CreateApplicantRequest, CreateApplicantResponse>, GetSupported<Long, GetApplicantResponse>,
        UpdateSupported<UpdateApplicantResponse, UpdateApplicantRequest, Long>, DeleteSupported<Long> {

    private final ApplicantRepository applicantRepository;
    private final CourseRepository courseRepository;


    public ApplicantService(ApplicantRepository applicantRepository, CourseRepository courseRepository) {
        this.applicantRepository = applicantRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public CreateApplicantResponse add(CreateApplicantRequest createApplicantRequest) {

        boolean existBy = courseRepository.existsById(createApplicantRequest.getCourse_id());
        if (!existBy) {
            throw new CourseNotFoundException(createApplicantRequest.getCourse_id());
        }
        Applicant applicant = new Applicant();
        BeanUtils.copyProperties(createApplicantRequest, applicant);
        Course course = courseRepository.findById(createApplicantRequest.getCourse_id()).get();
        applicant.setCourse(course);
        Applicant saved = applicantRepository.save(applicant);
        CreateApplicantResponse createApplicantResponse = new CreateApplicantResponse();
        BeanUtils.copyProperties(saved, createApplicantResponse);
        return createApplicantResponse;

    }

    @Override
    public GetApplicantResponse get(Long id) {
        boolean existBy = applicantRepository.existsById(id);
        if (!existBy) {
            throw new ApplicantNotFoundException(id);
        }
        GetApplicantResponse getApplicantResponse = new GetApplicantResponse();
        Applicant applicant = applicantRepository.findById(id).get();
        BeanUtils.copyProperties(applicant, getApplicantResponse);

        return getApplicantResponse;

    }

    @Override
    public List<GetApplicantResponse> getAll() {
        List<GetApplicantResponse> getApplicantResponseList = new ArrayList<>();
        List<Applicant> applicantList = applicantRepository.findAll();

        for (Applicant applicant : applicantList) {
            GetApplicantResponse getApplicantResponse = new GetApplicantResponse();
            BeanUtils.copyProperties(applicant, getApplicantResponse);
            getApplicantResponseList.add(getApplicantResponse);
        }

        BeanUtils.copyProperties(applicantList, getApplicantResponseList);
        return getApplicantResponseList;
    }

    @Override
    public UpdateApplicantResponse update(UpdateApplicantRequest updateApplicantRequest, Long id) {
        boolean existBy = applicantRepository.existsById(id);
        if (!existBy) {
            throw new ApplicantNotFoundException(id);
        }
        UpdateApplicantResponse updateApplicantResponse = new UpdateApplicantResponse();
        Applicant applicant = applicantRepository.findById(id).get();
        BeanUtils.copyProperties(updateApplicantRequest, applicant);
        Applicant saved = applicantRepository.save(applicant);
        BeanUtils.copyProperties(saved, updateApplicantResponse);
        return updateApplicantResponse;
    }

    @Override
    public void delete(Long id) {
        boolean existBy = applicantRepository.existsById(id);
        if (!existBy) {
            throw new ApplicantNotFoundException(id);
        }
        applicantRepository.deleteById(id);

    }


}
