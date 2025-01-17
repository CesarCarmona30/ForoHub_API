package com.forohub.api.controller;

import com.forohub.api.domain.user.UserRequestDTO;
import com.forohub.api.domain.user.UserResponseDTO;
import com.forohub.api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequest) {
        // Llama al servicio para registrar el usuario
        UserResponseDTO registeredUser = userService.registerUser(userRequest);
        return ResponseEntity.ok(registeredUser);
    }
}
