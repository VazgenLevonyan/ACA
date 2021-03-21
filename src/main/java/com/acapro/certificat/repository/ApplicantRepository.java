package com.acapro.certificat.repository;

import com.acapro.certificat.entity.Applicant;
import com.acapro.certificat.transfer.response.applicant.GetApplicantResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    @Query("select a "
            + " from Applicant a "
            + " where (:name is null or a.name = :name) "
            + "   and (:email is null or a.email = :email) "
            + "   and (:courseId is null or a.course.id = :courseId) ")
    Page<Applicant> search(
            @Param("name") String name,
            @Param("email") String email,
            @Param("courseId") Long courseId,
            Pageable pageable
    );

}
