package com.acapro.certificat.transfer.request.course;

import lombok.Data;

@Data
public class UpdateCourseRequest {
    private String name;
    private String teacherName;
    private String description;
}
