package com.acapro.certificat.transfer.response.course;

import lombok.Data;

@Data
public class GetCourseResponse {
    private String name;
    private String teacherName;
    private String description;
}
