package com.yazykov.projectf.services;

import com.yazykov.projectf.models.security.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    public void saveUser(User user);

    public User getUserByUsername(String username);
}
