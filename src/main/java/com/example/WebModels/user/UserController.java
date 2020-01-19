package com.example.WebModels.user;

import com.example.WebModels.login.LoginForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/add")
    public ResponseEntity<String> addUser(@RequestBody LoginForm loginForm){

        if(!loginForm.getPassword().equals(loginForm.getPasswordCheck()))
            return new ResponseEntity<>("Passwords doesn't match", HttpStatus.CONFLICT);

        userService.addUser(loginForm);
        return new ResponseEntity<>("User added", HttpStatus.OK);
    }

    @GetMapping("/user/all")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
