package org.example.syncautomation.controller.user;


import lombok.extern.slf4j.Slf4j;
import org.example.syncautomation.service.UserService;
import org.example.syncautomation.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user)
    {
        log.info("create user {}", user);

        return userService.createUser(user);
    }
}
