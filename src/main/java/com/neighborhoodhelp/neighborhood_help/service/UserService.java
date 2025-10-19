package com.neighborhoodhelp.neighborhood_help.service;



import com.neighborhoodhelp.neighborhood_help.model.User;
import com.neighborhoodhelp.neighborhood_help.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        user.setJoinDate(Instant.now());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
