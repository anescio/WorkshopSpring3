package com.skni.workshopspring3.repo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "course")
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
