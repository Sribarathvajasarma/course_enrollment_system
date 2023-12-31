package com.project.availabilityservice.controller;

import com.project.availabilityservice.service.AvailablityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/availablity")
@RequiredArgsConstructor
public class AvailablityController {

    private final AvailablityService availablityService;
    @GetMapping("/{course-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isAvailable(@PathVariable("course-code") String courseCode){
        return availablityService.isAvailable(courseCode);
    }
}
