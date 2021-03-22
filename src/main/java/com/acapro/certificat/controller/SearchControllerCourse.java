package com.acapro.certificat.controller;

import com.acapro.certificat.entity.Course;
import com.acapro.certificat.repository.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/courses")
public class SearchControllerCourse {

    private final CourseRepository courseRepository;

    public SearchControllerCourse(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/search")
    public Page<Course> search(
            @RequestParam(value = "name", required = false) String name, Pageable pageable) {
        return courseRepository.search(name, pageable);
    }
}