package com.project.enrollmentservice.controller;

import com.project.enrollmentservice.dto.EnrollmentRequest;
import com.project.enrollmentservice.service.EnrollService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/enroll")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollService enrollService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "availability", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "availability")
    @Retry(name = "availability")
    public CompletableFuture<String> enroll(@RequestBody EnrollmentRequest enrollmentRequest){
        return CompletableFuture.supplyAsync(() -> enrollService.enroll(enrollmentRequest));
    }

    public CompletableFuture<String> fallbackMethod(EnrollmentRequest enrollmentRequest, RuntimeException runtimeException){
        return CompletableFuture.supplyAsync(()->"Sorry, Something went wrong, please order after some time.");

    }
}
