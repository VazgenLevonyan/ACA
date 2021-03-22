package com.acapro.certificat.repository;

import com.acapro.certificat.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select b "
            + " from Course b "
            + " where (:name is null or b.name = :name) "
            )
    Page<Course> search(
            @Param("name") String name, Pageable pageable);
}
