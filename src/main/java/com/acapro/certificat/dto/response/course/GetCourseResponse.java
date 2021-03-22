package com.acapro.certificat.dto.response.course;

import lombok.Data;

@Data
public class GetCourseResponse {
    private String name;
    private String teacherName;
    private String description;
}
