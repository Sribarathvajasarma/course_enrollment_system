package com.project.availabilityservice.repository;

import com.project.availabilityservice.model.Availablity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AvailablityRepository extends JpaRepository<Availablity, Long> {

    List<Availablity> findByCourseCodeIn(List<String> courseCode);
}
