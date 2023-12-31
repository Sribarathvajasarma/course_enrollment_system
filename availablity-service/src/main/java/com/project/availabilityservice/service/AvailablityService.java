package com.project.availabilityservice.service;

import com.project.availabilityservice.repository.AvailablityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AvailablityService {

    private final AvailablityRepository availablityRepository;
    @Transactional(readOnly = true)
    public  boolean isAvailable(String courseCode){
        return availablityRepository.findByCourseCode(courseCode).isPresent();
    }
}
