package com.apidocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apidocker.model.User;



/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {}