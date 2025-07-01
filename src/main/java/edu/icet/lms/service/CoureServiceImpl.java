package edu.icet.lms.service;

import edu.icet.lms.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CoureServiceImpl implements CourseService {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public int createCourse(Course course) {
        String sql = "INSERT INTO courses (title, description, instructor) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, course.getTitle(), course.getDescription(), course.getInstructor());
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        String sql = "SELECT * FROM courses WHERE id = ?";
        List<Course> courses = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> new Course(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("instructor")
        ));
        return courses.stream().findFirst();
    }

    @Override
    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM courses";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Course(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("instructor")
        ));
    }

    @Override
    public int updateCourse(Course course) {
        String sql = "UPDATE courses SET title = ?, description = ?, instructor = ? WHERE id = ?";
        return jdbcTemplate.update(sql, course.getTitle(), course.getDescription(), course.getInstructor(), course.getId());
    }

    @Override
    public int deleteCourse(Long id) {
        String sql = "DELETE FROM courses WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
