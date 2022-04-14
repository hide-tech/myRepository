package com.yazykov.projectf.controllers;

import com.yazykov.projectf.dto.LoginDto;
import com.yazykov.projectf.models.security.Status;
import com.yazykov.projectf.models.security.User;
import com.yazykov.projectf.services.RoleService;
import com.yazykov.projectf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto){
        return null;
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
        user.setPassword(passwordEncoder.encode(userdto.getPassword()));
        user.setRoles(roleService.getUserRole());
        user.setCreated(LocalDateTime.now());
        user.setUpdated(LocalDateTime.now());
        user.setStatus(Status.ACTIVE);
        userService.saveUser(user);
        model.addAttribute("usernew", user);
        return "success";
    }

}
