package com.virtualshop.msuser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualshop.msuser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
