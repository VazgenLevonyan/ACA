package com.acapro.certificat.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "course")
@Data
public class Course {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "teacher_name", nullable = false)
    private String teacherName;

    @Column(name = "description")
    private String description;

//    @OneToMany(mappedBy = "course")
//    List<Applicant> applicantList = new ArrayList<>();

}
