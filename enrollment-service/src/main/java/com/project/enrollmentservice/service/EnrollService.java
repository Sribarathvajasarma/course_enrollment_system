package com.project.enrollmentservice.service;

import com.project.enrollmentservice.dto.AvailablityResponse;
import com.project.enrollmentservice.dto.EnrollCoursesDto;
import com.project.enrollmentservice.dto.EnrollmentRequest;
import com.project.enrollmentservice.model.EnrollCourses;
import com.project.enrollmentservice.model.Enrollment;
import com.project.enrollmentservice.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class EnrollService {

    private final EnrollmentRepository enrollmentRepository;
    private final WebClient.Builder webClientBuilder;

    public String enroll(EnrollmentRequest enrollmentRequest){

        Enrollment enrollment = new Enrollment();
        enrollment.setEnrollmentNumber(UUID.randomUUID().toString());

        List<EnrollCourses> enrollCourses = enrollmentRequest.getEnrollCoursesDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        enrollment.setEnrollCoursesList(enrollCourses);

        List<String> courseCodes = enrollment.getEnrollCoursesList().stream()
                .map(EnrollCourses::getCourseCode)
                .toList();

        AvailablityResponse[] availablityResponses = webClientBuilder.build().get()
                .uri("http://AVAILABLITY-SERVICE/api/availablity", uriBuilder -> uriBuilder.queryParam("courseCode", courseCodes).build())
                        .retrieve()
                                .bodyToMono(AvailablityResponse[].class)
                                        .block();

        boolean allCoursesAvailable = Arrays.stream(availablityResponses).allMatch(AvailablityResponse::isAvailable);

        if(allCoursesAvailable){
            enrollmentRepository.save(enrollment);
            return "Enrolled successfully";
        }else {
            throw new IllegalArgumentException("There is no slot available for this course");
        }


    }

    private EnrollCourses mapToDto(EnrollCoursesDto enrollCoursesDto) {
        EnrollCourses enrollCourses = new EnrollCourses();
        enrollCourses.setPrice(enrollCoursesDto.getPrice());
        enrollCourses.setCourseCode(enrollCoursesDto.getCourseCode());

        return enrollCourses;
    }
}
