package de.tekup.jpademoa.security.controllers;

import de.tekup.jpademoa.security.entites.LoginRequest;
import de.tekup.jpademoa.security.entites.User;
import de.tekup.jpademoa.security.services.TokenService;
import de.tekup.jpademoa.security.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AuthController {


    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    private UserService userService;



    @PostMapping("/token")
    public String token(@RequestBody LoginRequest userLogin) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));

        System.out.println("Token requested for user: "+ authentication.getName());
        String token = tokenService.generateToken(authentication);
        System.out.println("Token granted: "+ token);
        System.out.println("************token ended************");
        return token;
    }

    @PostMapping("/register")
    public String register(@Valid  @RequestBody User userRegister) {
        userService.registerUser(userRegister);
        return "User Registered";
    }

}