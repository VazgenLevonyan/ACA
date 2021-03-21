package com.acapro.certificat.repository;

import com.acapro.certificat.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
