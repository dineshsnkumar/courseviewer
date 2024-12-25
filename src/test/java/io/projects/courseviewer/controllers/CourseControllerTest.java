package io.projects.courseviewer.controllers;


import io.projects.courseviewer.entities.Course;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CourseControllerTest {
   @Autowired
   private WebTestClient webClient;

   @Autowired
   private JdbcClient jdbcClient;

   private List<Long> getIds(){
       return jdbcClient.sql("SELECT id FROM course").query(Long.class).list();
   }

   @Test
   void getAllCourses(){
       webClient.get()
               .uri("/courses")
               .exchange()
               .expectStatus()
               .isOk()
               .expectBodyList(Course.class).hasSize(2);
   }

   @ParameterizedTest()
   @MethodSource("getIds")
   void getCourseThatExist(Long id){
        webClient.get()
                .uri("/courses/{id}", id)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(id);
   }

   @Test
    void getCourseThatDoesNotExist(){
        webClient.get()
                .uri("/courses/{id}", 99L)
                .exchange()
                .expectStatus().isOk();
    }

}
