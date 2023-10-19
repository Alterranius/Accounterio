package ru.accounterio.cost_management.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.accounterio.cost_management.domains.User;
import ru.accounterio.cost_management.interfaces.user.UserService;

@RestController
@RequestMapping("api/v1/user")
@Tag(name = "User API", description = "Used as external gateway")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "New User registration")
    @PostMapping("/new")
    public ResponseEntity<HttpStatus> performRegistration(@RequestBody User user) {

    }

    @Operation(summary = "User Login perform")
    @PostMapping("/login")
    public ResponseEntity<HttpStatus> performLogin(@RequestBody User user) {

    }

    @Operation(summary = "Delete User")
    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("user_id") Long userId) {

    }
}
