package com.yazykov.projectf.services.impl;

import com.yazykov.projectf.models.security.Role;
import com.yazykov.projectf.repositories.RoleRepository;
import com.yazykov.projectf.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getUserRole(){
        return List.of(roleRepository.getById(1L));
    }
}
