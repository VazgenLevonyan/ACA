package com.acapro.certificat.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "course")
            @JsonBackReference
    Set<Applicant> applicantList = new HashSet<>();
}
