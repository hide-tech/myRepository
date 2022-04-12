package com.yazykov.projectf.services;

import com.yazykov.projectf.models.security.Role;
import com.yazykov.projectf.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getUserRole(){
        return List.of(roleRepository.getById(1L));
    }
}
