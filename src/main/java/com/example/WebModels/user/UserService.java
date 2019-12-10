package com.example.WebModels.user;

import com.example.WebModels.login.LoginForm;
import com.example.WebModels.user.authority.Authority;
import com.example.WebModels.user.authority.AuthorityRepository;
import com.example.WebModels.user.authority.AuthorityType;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    protected void addUser(LoginForm loginForm){
        User user = new User();
        Authority authorityUser = new Authority();
        authorityUser.setAuthorityType(AuthorityType.ROLE_USER);
        user.setAuthority(authorityUser);
        user.setUsername(loginForm.getUsername());
        user.setPassword(encoder.encode(loginForm.getPassword()));
        userRepository.save(user);
    }

    protected List<User> getUsers(){
       return userRepository.findAll();
    }
}
