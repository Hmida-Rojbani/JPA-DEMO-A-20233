package de.tekup.jpademoa.security.services;


import de.tekup.jpademoa.security.entites.Role;
import de.tekup.jpademoa.security.entites.User;
import de.tekup.jpademoa.security.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public void registerUser(User user){
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);
    }

}