package com.project.availabilityservice.controller;

import com.project.availabilityservice.dto.AvailablityResponse;
import com.project.availabilityservice.service.AvailablityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/availablity")
@RequiredArgsConstructor
public class AvailablityController {

    private final AvailablityService availablityService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AvailablityResponse> isAvailable(@RequestParam List<String> courseCode){
        return availablityService.isAvailable(courseCode);
    }
}
