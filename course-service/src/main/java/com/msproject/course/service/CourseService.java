package com.msproject.course.service;

import com.msproject.course.dto.CourseRequest;
import com.msproject.course.dto.CourseResponse;
import com.msproject.course.model.Course;
import com.msproject.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {

    private final CourseRepository courseRepository;

    public void createCourse(CourseRequest courseRequest){
        Course course = Course.builder()
                .name(courseRequest.getName())
                .description(courseRequest.getDescription())
                .price(courseRequest.getPrice())
                .build();

        courseRepository.save(course);
        log.info("Course {} is saved", course.getId());
    }

    public List<CourseResponse> getAllCourses() {
        List<Course> courses = courseRepository.findAll();

        return courses.stream().map(this::mapToCourseResponse).toList();
    }

    private CourseResponse mapToCourseResponse(Course course) {
        return CourseResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .description(course.getDescription())
                .price(course.getPrice())
                .build();
    }
}
