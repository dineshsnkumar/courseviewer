package io.projects.courseviewer.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "course")
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name" )
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Column(name ="description" )
    @NotEmpty(message = "description cannot be empty")
    private String description;

    @Column(name ="cost of the product" )
    @PositiveOrZero(message = "Product price has to be positive or zero")
    private BigDecimal price;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }


    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course( String name, String description, BigDecimal price) {
        this.description = description;
        this.name = name;
        this.price = price;
    }

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
