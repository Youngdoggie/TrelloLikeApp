package com.example.Trello.Group12.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{ID}")
    public User getWorkspaces(@PathVariable int ID) {
        return userService.getWorkspaces(ID);
    }

    @PostMapping("/register")
    public boolean registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public int login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        return userService.login(email, password);
    }

    @PutMapping("/forgot")
    public boolean forgotPassword(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String answer = body.get("answer");
        String password = body.get("password");
        return userService.forgotPassword(email,answer,password);
    }


}
