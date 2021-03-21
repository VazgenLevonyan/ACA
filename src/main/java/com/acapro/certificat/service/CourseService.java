package com.acapro.certificat.service;

import com.acapro.certificat.exceptions.CourseNotFoundException;
import com.acapro.certificat.repository.CourseRepository;
import com.acapro.certificat.entity.Course;
import com.acapro.certificat.transfer.request.course.CreateCourseRequest;
import com.acapro.certificat.transfer.request.course.UpdateCourseRequest;
import com.acapro.certificat.transfer.response.course.CreateCourseResponse;
import com.acapro.certificat.transfer.response.course.GetCourseResponse;
import com.acapro.certificat.transfer.response.course.UpdateCourseResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements AddSupported<CreateCourseRequest, CreateCourseResponse>,
        GetSupported<Long, GetCourseResponse>, UpdateSupported<UpdateCourseResponse, UpdateCourseRequest, Long>, DeleteSupported<Long> {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public CreateCourseResponse add(CreateCourseRequest createCourseRequest) {
        Course course = new Course();
        course.setStartDate(LocalDateTime.now());
        BeanUtils.copyProperties(createCourseRequest, course);
        course.setEndDate(LocalDateTime.now());
        Course saved = courseRepository.save(course);
        CreateCourseResponse createCourseResponse = new CreateCourseResponse();
        BeanUtils.copyProperties(saved, createCourseResponse);
        return createCourseResponse;

    }

    @Override
    public GetCourseResponse get(Long id) {
        boolean existBy = courseRepository.existsById(id);
        if (!existBy) {
            throw new CourseNotFoundException(id);
        }

        Course course = courseRepository.findById(id).get();
        GetCourseResponse getCourseResponse = new GetCourseResponse();

        BeanUtils.copyProperties(course, getCourseResponse);
        return getCourseResponse;


    }

    @Override
    public List<GetCourseResponse> getAll() {

        List<GetCourseResponse> getCourseResponseList = new ArrayList<>();
        List<Course> courseList = courseRepository.findAll();

        for (Course course : courseList) {
            GetCourseResponse getCourseResponse = new GetCourseResponse();
            BeanUtils.copyProperties(course, getCourseResponse);
            getCourseResponseList.add(getCourseResponse);
        }

        BeanUtils.copyProperties(courseList, getCourseResponseList);
        return getCourseResponseList;


    }

    @Override
    public UpdateCourseResponse update(UpdateCourseRequest createCourseRequest, Long id) {

        boolean existBy= courseRepository.existsById(id);
        if(!existBy){
            throw new CourseNotFoundException(id);
        }

        Course course = courseRepository.findById(id).get();
        UpdateCourseResponse updateCourseResponse = new UpdateCourseResponse();
        BeanUtils.copyProperties(createCourseRequest,course);
        Course save = courseRepository.save(course);
        BeanUtils.copyProperties(save,updateCourseResponse);
        return updateCourseResponse;


    }

    @Override
    public void delete(Long id) {
        boolean existBy= courseRepository.existsById(id);
        if(!existBy){
            throw new CourseNotFoundException(id);
        }
        courseRepository.deleteById(id);

    }
}
