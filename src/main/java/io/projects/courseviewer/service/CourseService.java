package io.projects.courseviewer.service;

import io.projects.courseviewer.dao.CourseRepository;
import io.projects.courseviewer.entities.Course;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id){
        return courseRepository.findById(id);
    }

    public Course saveOrUpdateCourse(Course course){
        return courseRepository.save(course);
    }

    public void delete(Course course){
        courseRepository.delete(course);
    }

    public void deleteById(long id){
        courseRepository.deleteById(id);
    }

}
