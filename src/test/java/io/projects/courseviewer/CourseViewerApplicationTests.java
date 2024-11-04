package io.projects.courseviewer;

import io.projects.courseviewer.entities.Course;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CourseViewerApplicationTests {

    @Autowired
    private Validator validator;

    @Test
    void nameValid() {
        Course course = new Course("Ecology 101");
        var violations = validator.validate(course);
        assertTrue(violations.isEmpty());
    }

    @Test
    void nameInvalid() {
        Course course = new Course();
        var violations = validator.validate(course);
        assertEquals(1, violations.size());
    }
}
