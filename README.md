# courseviewer

- Overview: Ecommerce website similar to Udemy
- Repository for backend portion of CourseViewer

### Requirements

- Users can add courses
- Get the list of all courses
- Update and delete course 
- Adding batch courses to database
- Users can signup, login and logout


### Endpoints

- GET all courses  ``` /courses```
- GET a specific course ```/courses/{id}```
- POST a new course ```/courses```
```json
 {
        "name": "Modern Poetry",
        "description": "Learn about modern poetry from Philip Larkin to Rupi Kaur"
}
```


### Backend Technologies used

- Spring Boot + Docker compose + Spring Security + Postgres + Spring Batch