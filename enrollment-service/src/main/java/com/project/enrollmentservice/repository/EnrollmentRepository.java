package com.project.enrollmentservice.repository;

import com.project.enrollmentservice.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
