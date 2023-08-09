package com.henrique.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.henrique.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
