package io.projects.courseviewer.controllers;

import io.projects.courseviewer.entities.Course;
import io.projects.courseviewer.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
 Main controller which fetches the list of courses, specific course, course details
 */
@RestController
public class CourseController {

    private final CourseService courseService;

   public CourseController(CourseService courseService){
       this.courseService = courseService;
   }

    @GetMapping("/courses")
    public List<Course> courses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public Optional<Course> courses(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

}
