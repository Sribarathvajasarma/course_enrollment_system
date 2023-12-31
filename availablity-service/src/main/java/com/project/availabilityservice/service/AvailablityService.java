package com.project.availabilityservice.service;

import com.project.availabilityservice.dto.AvailablityResponse;
import com.project.availabilityservice.repository.AvailablityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvailablityService {

    private final AvailablityRepository availablityRepository;
    @Transactional(readOnly = true)
    public List<AvailablityResponse> isAvailable(List<String> courseCode){
        return availablityRepository.findByCourseCodeIn(courseCode).stream()
                .map(availablity ->
                    AvailablityResponse.builder().courseCode(availablity.getCourseCode())
                            .isAvailable(availablity.getSlots() > 0)
                            .build()
                ).toList();
    }
}
