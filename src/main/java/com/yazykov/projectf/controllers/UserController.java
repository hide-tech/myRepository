package com.yazykov.projectf.controllers;

import com.yazykov.projectf.models.security.Status;
import com.yazykov.projectf.models.security.User;
import com.yazykov.projectf.repositories.RoleRepository;
import com.yazykov.projectf.repositories.UserRepository;
import com.yazykov.projectf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "auth";
    }

    @GetMapping("/create")
    public String getCreateUserPage(@ModelAttribute("user") User userdto){
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") @Valid User userdto,
                             BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "create";
        }

        User user = new User();
        user.setUsername(userdto.getUsername());
        user.setFirstName(userdto.getFirstName());
        user.setLastName(userdto.getLastName());
        user.setEmail(userdto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(userdto.getPassword()));
        user.setRoles(List.of(roleRepository.getById(1L)));
        user.setCreated(LocalDateTime.now());
        user.setUpdated(LocalDateTime.now());
        user.setStatus(Status.ACTIVE);
        userRepository.save(user);
        model.addAttribute("usernew", user);
        return "success";
    }

}
