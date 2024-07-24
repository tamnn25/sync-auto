package org.example.syncautomation.service.impl;

import org.example.syncautomation.repository.user.UserRepository;
import org.example.syncautomation.service.UserService;
import org.example.syncautomation.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public  User createUser(User user)
    {
        return userRepository.save(user);
    }
}
