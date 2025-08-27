/**
 * 
 */
package com.online.OnlineShoping.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.OnlineShoping.model.User;
import com.online.OnlineShoping.repositry.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepository userRepository;

    public Optional<User> validateUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
 
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
