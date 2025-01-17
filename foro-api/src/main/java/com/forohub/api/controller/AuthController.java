package com.forohub.api.controller;

import com.forohub.api.domain.login.LoginDTO;
import com.forohub.api.domain.user.User;
import com.forohub.api.infra.security.JWTData;
import com.forohub.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authUser(@RequestBody @Valid LoginDTO loginDTO) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                loginDTO.username(), loginDTO.password());
        var authUser = authenticationManager.authenticate(authToken);
        var JWToken = tokenService.getToken((User) authUser.getPrincipal());
        return ResponseEntity.ok(new JWTData(JWToken));
    }
}