package com.online.OnlineShoping.services;

import java.util.List;
import java.util.Optional;

import com.online.OnlineShoping.model.User;

public interface UserService {
	public Optional<User> validateUser(String username, String password);
	public User saveUser(User user);
	public List<User> fetchAllUser();

}
