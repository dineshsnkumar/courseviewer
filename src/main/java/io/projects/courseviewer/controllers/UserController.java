package io.projects.courseviewer.controllers;

import io.projects.courseviewer.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("")
    private List<User> users() {
        return new ArrayList<User>();
    }

}
