package com.example.pp311.pp311.service;

import org.springframework.stereotype.Service;
import com.example.pp311.pp311.model.User;
import com.example.pp311.pp311.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    public List findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void remove(Long id) {
        userRepository.remove(id);
    }
}
