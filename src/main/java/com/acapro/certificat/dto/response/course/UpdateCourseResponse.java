package com.acapro.certificat.dto.response.course;

import lombok.Data;

@Data
public class UpdateCourseResponse {
    private String name;
    private String teacherName;
    private String description;
}
