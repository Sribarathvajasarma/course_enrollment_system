package com.project.enrollmentservice.service;

import com.project.enrollmentservice.dto.EnrollCoursesDto;
import com.project.enrollmentservice.dto.EnrollmentRequest;
import com.project.enrollmentservice.model.EnrollCourses;
import com.project.enrollmentservice.model.Enrollment;
import com.project.enrollmentservice.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class EnrollService {

    private final EnrollmentRepository enrollmentRepository;

    public void enroll(EnrollmentRequest enrollmentRequest){

        Enrollment enrollment = new Enrollment();
        enrollment.setEnrollmentNumber(UUID.randomUUID().toString());

        List<EnrollCourses> enrollCourses = enrollmentRequest.getEnrollCoursesDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        enrollment.setEnrollCoursesList(enrollCourses);

        enrollmentRepository.save(enrollment);

    }

    private EnrollCourses mapToDto(EnrollCoursesDto enrollCoursesDto) {
        EnrollCourses enrollCourses = new EnrollCourses();
        enrollCourses.setPrice(enrollCoursesDto.getPrice());
        enrollCourses.setCourseCode(enrollCoursesDto.getCourseCode());

        return enrollCourses;
    }
}
