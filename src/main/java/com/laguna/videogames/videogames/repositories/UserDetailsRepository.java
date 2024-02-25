package com.laguna.videogames.videogames.repositories;

import com.laguna.videogames.videogames.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
