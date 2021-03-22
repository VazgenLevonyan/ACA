package com.acapro.certificat.controller;
import com.acapro.certificat.api.ApiResponse;
import com.acapro.certificat.service.CourseService;
import com.acapro.certificat.dto.request.course.CreateCourseRequest;
import com.acapro.certificat.dto.request.course.UpdateCourseRequest;
import com.acapro.certificat.dto.response.course.CreateCourseResponse;
import com.acapro.certificat.dto.response.course.GetCourseResponse;
import com.acapro.certificat.dto.response.course.UpdateCourseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public ApiResponse<CreateCourseResponse> createCourse(@RequestBody CreateCourseRequest createCourseRequest) {
        return new ApiResponse<>("Course successfully created", HttpStatus.OK.value(), courseService.createCourse(createCourseRequest));
    }

    @GetMapping("{id}")
    public ApiResponse<GetCourseResponse> getCourse(@PathVariable Long id) {
        return new ApiResponse<>(String.format("Course  by id: {%d}",id), HttpStatus.CREATED.value(), courseService.getCourse(id));
    }

    @GetMapping("/all")
    public ApiResponse<List<GetCourseResponse>> getAllCourses() {
        return new ApiResponse<>("All courses", HttpStatus.OK.value(), courseService.getAllCourses());
    }

    @PutMapping("{id}")
    public ApiResponse<UpdateCourseResponse> updateCourse(@RequestBody UpdateCourseRequest updateCourseRequest, @PathVariable Long id) {

        return new ApiResponse<>(String.format("Course  by id: {%d} successfully updated", id), HttpStatus.OK.value(), courseService.updateCourse(updateCourseRequest, id));
    }

    @DeleteMapping("{id}")
    public ApiResponse<Void> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return new ApiResponse<>(String.format("Course by id: {%d} successfully removed", id),HttpStatus.OK.value());
    }
}
