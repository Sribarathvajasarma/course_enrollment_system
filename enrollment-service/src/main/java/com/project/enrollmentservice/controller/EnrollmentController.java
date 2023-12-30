package com.project.enrollmentservice.controller;

import com.project.enrollmentservice.dto.EnrollmentRequest;
import com.project.enrollmentservice.service.EnrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enroll")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollService enrollService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String enroll(@RequestBody EnrollmentRequest enrollmentRequest){
        enrollService.enroll(enrollmentRequest);
        return "Enrolled successfully";
    }
}
