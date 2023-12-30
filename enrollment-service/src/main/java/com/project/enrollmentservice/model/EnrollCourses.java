package com.project.enrollmentservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "t_enroll_courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnrollCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseCode;
    private BigDecimal price;

}
