package com.neighborhoodhelp.neighborhood_help.repository;



import com.neighborhoodhelp.neighborhood_help.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}

