package io.projects.courseviewer.controllers;


import io.projects.courseviewer.models.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCourse(){
     ResponseEntity<Course> course = restTemplate.getForEntity("/courses/1", Course.class);
     assertTrue(course.getStatusCode().is2xxSuccessful());
    }
}
