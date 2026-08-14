package com.library.controller;
import com.library.model.LoginRequest;
import com.library.model.User;
import com.library.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody LoginRequest request){
        return authService.register(request.getUsername(), request.getPassword(), request.getRole());
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        return authService.login(request.getUsername(), request.getPassword());
    }
}