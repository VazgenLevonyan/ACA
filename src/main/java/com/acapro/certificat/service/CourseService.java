package com.acapro.certificat.service;

import com.acapro.certificat.exception.CourseNotFoundException;
import com.acapro.certificat.repository.CourseRepository;
import com.acapro.certificat.entity.Course;
import com.acapro.certificat.dto.request.course.CreateCourseRequest;
import com.acapro.certificat.dto.request.course.UpdateCourseRequest;
import com.acapro.certificat.dto.response.course.CreateCourseResponse;
import com.acapro.certificat.dto.response.course.GetCourseResponse;
import com.acapro.certificat.dto.response.course.UpdateCourseResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CreateCourseResponse createCourse(CreateCourseRequest createCourseRequest) {
        Course course = new Course();
        course.setStartDate(LocalDateTime.now());
        BeanUtils.copyProperties(createCourseRequest, course);
        course.setEndDate(LocalDateTime.now());
        Course saved = courseRepository.save(course);
        CreateCourseResponse createCourseResponse = new CreateCourseResponse();
        BeanUtils.copyProperties(saved, createCourseResponse);
        return createCourseResponse;
    }

    public GetCourseResponse getCourse(Long id) {
        Course course=courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        GetCourseResponse getCourseResponse = new GetCourseResponse();
        BeanUtils.copyProperties(course, getCourseResponse);
        return getCourseResponse;
    }


    public List<GetCourseResponse> getAllCourses() {
        List<GetCourseResponse> getCourseResponseList = new ArrayList<>();
        List<Course> courseList = courseRepository.findAll();
        for (Course course : courseList) {
            GetCourseResponse getCourseResponse = new GetCourseResponse();
            BeanUtils.copyProperties(course, getCourseResponse);
            getCourseResponseList.add(getCourseResponse);
        }
        return getCourseResponseList;
    }

    public UpdateCourseResponse updateCourse(UpdateCourseRequest createCourseRequest, Long id) {
        Course course = courseRepository.findById(id).orElseThrow(()-> new CourseNotFoundException(id));
        UpdateCourseResponse updateCourseResponse = new UpdateCourseResponse();
        BeanUtils.copyProperties(createCourseRequest,course);
        Course save = courseRepository.save(course);
        BeanUtils.copyProperties(save,updateCourseResponse);
        return updateCourseResponse;
    }


    public void deleteCourse(Long id) {
        Course course= courseRepository.findById(id).orElseThrow(()-> new CourseNotFoundException(id));
        courseRepository.delete(course);
    }
}
