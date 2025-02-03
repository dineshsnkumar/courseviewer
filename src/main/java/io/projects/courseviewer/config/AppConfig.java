package io.projects.courseviewer.config;

import io.projects.courseviewer.dao.CourseRepository;
import io.projects.courseviewer.entities.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppConfig implements CommandLineRunner {

    private final CourseRepository courseRepository;

    public AppConfig(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (courseRepository.count() == 0){
            courseRepository.saveAll(
                    List.of(
                            new Course("Intro to World Religions", "Learn about different religions of the world"),
                            new Course( "American Literature", "Read and discuss about American authors ")
                            )
            ).forEach(System.out::println);
        }
    }
}
