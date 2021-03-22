package com.acapro.certificat.dto.response.course;

import lombok.Data;

@Data
public class CreateCourseResponse {
    private Long id;
    private String name;
    private String teacherName;
    private String description;
}
