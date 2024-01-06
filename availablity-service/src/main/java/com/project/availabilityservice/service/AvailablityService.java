package com.project.availabilityservice.service;

import com.project.availabilityservice.dto.AvailablityResponse;
import com.project.availabilityservice.repository.AvailablityRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AvailablityService {

    private final AvailablityRepository availablityRepository;
    @SneakyThrows
    @Transactional(readOnly = true)
    public List<AvailablityResponse> isAvailable(List<String> courseCode){
        log.info("wait started");
        Thread.sleep(10000);
        log.info("wait ended");
        return availablityRepository.findByCourseCodeIn(courseCode).stream()
                .map(availablity ->
                    AvailablityResponse.builder().courseCode(availablity.getCourseCode())
                            .isAvailable(availablity.getSlots() > 0)
                            .build()
                ).toList();
    }
}
