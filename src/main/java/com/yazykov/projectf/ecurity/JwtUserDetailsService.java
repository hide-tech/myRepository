package com.yazykov.projectf.ecurity;

import com.yazykov.projectf.ecurity.jwt.JwtUser;
import com.yazykov.projectf.ecurity.jwt.JwtUserFactory;
import com.yazykov.projectf.models.security.User;
import com.yazykov.projectf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("jwtDetails")
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user  = userService.getUserByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        return jwtUser;
    }
}
