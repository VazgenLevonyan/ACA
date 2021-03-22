package com.acapro.certificat.dto.request.course;

import lombok.Data;

@Data
public class UpdateCourseRequest {
    private String name;
    private String teacherName;
    private String description;
}
