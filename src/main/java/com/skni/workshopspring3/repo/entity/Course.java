package com.skni.workshopspring3.repo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "university")
    private String university;

    @Column(name = "courseType")
    @Enumerated(EnumType.STRING)
    private CourseTypeEnum courseType;

}
