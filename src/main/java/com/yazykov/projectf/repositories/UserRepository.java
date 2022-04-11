package com.yazykov.projectf.repositories;

import com.yazykov.projectf.models.security.User;
import org.hibernate.annotations.Fetch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    
    User findByUsername(String username);
}
