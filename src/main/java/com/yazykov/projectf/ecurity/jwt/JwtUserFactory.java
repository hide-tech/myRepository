package com.yazykov.projectf.ecurity.jwt;

import com.yazykov.projectf.models.security.Role;
import com.yazykov.projectf.models.security.Status;
import com.yazykov.projectf.models.security.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.sql.Date;
import java.time.ZoneId;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    public JwtUserFactory(){
    }

    public static JwtUser create(User user){
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                Date.valueOf(user.getUpdated().toLocalDate()),
                user.getStatus().equals(Status.ACTIVE),
                mapToGrantedAuthorities(user.getRoles()));
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Collection<Role> userRoles){
        return userRoles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
