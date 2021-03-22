package com.acapro.certificat.controller;
import com.acapro.certificat.entity.Applicant;
import com.acapro.certificat.repository.ApplicantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applicants")
public class SearchControllerApplicant {

    private final ApplicantRepository applicantRepository;

    public SearchControllerApplicant(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @GetMapping("/search")
    public Page<Applicant> search(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "courseId", required = false) Long courseId,
            Pageable pageable) {
        return applicantRepository.search(name, email, courseId, pageable);
    }
}
