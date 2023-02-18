package de.onpier.controller;

import de.onpier.dto.User;
import de.onpier.service.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserSvc userSvc;

    @GetMapping("/borrowed")
    public List<User> availableBooks()
    {
        return userSvc.borrowed();
    }

    @GetMapping("/nonTerminatedUser")
    public List<User> nonTerminatedUser()
    {
        return userSvc.nonTerminatedUser();
    }

}
