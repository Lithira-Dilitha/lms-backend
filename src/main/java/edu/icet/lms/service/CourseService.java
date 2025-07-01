package edu.icet.lms.service;

import edu.icet.lms.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    int createCourse(Course course);
    Optional<Course> getCourseById(Long id);
    List<Course> getAllCourses();
    int updateCourse(Course course);
    int deleteCourse(Long id);
}
