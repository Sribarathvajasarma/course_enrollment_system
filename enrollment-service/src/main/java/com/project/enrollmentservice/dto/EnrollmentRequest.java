package com.project.enrollmentservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequest {
    private List<EnrollCoursesDto> enrollCoursesDtoList;
}
