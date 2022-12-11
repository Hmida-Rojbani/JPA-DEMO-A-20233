package de.tekup.jpademoa.security.entites;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
}
