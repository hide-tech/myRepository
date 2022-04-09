package com.yazykov.projectf.controllers;

import com.yazykov.projectf.dto.UserDto;
import com.yazykov.projectf.models.security.User;
import com.yazykov.projectf.repositories.RoleRepository;
import com.yazykov.projectf.repositories.UserRepository;
import com.yazykov.projectf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/create")
    public String createUser(@RequestBody UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRoles(List.of(roleRepository.getById(1L)));
        userRepository.save(user);
        return "auth_page";
    }

}
