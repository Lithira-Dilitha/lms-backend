package edu.icet.lms.controller;

import edu.icet.lms.model.Course;
import edu.icet.lms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<String> createCourse(@RequestBody Course course) {
        courseService.createCourse(course);
        return ResponseEntity.ok("Course created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        int updated = courseService.updateCourse(course);
        if (updated > 0) {
            return ResponseEntity.ok("Course updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        int deleted = courseService.deleteCourse(id);
        if (deleted > 0) {
            return ResponseEntity.ok("Course deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
