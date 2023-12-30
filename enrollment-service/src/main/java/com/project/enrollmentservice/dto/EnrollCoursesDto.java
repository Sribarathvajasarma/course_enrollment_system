package com.project.enrollmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollCoursesDto {
    private Long id;
    private String courseCode;
    private BigDecimal price;
}
