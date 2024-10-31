package io.projects.courseviewer.controllers;

import io.projects.courseviewer.models.Course;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
 Main controller which fetches the list of courses, specific course, course details
 */
@RestController
@RequestMapping("/courses")
public class CourseViewerController {

    @GetMapping("")
    public List<Course> courses(){
        List<Course> courses = new ArrayList<Course>();
        courses.add(new Course(101, "World Religion 101"));
        return courses;
    }

    @GetMapping("/{courseId}")
    public Course course(@PathVariable(required = false) int courseId){
        return new Course(courseId, "World Religion 101");
    }
}
