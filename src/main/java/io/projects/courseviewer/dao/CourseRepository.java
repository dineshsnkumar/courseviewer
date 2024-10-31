package io.projects.courseviewer.dao;

import io.projects.courseviewer.entities.Course;
import org.hibernate.boot.model.convert.spi.JpaAttributeConverterCreationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
