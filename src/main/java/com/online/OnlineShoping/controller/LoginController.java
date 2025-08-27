package com.online.OnlineShoping.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.OnlineShoping.model.LoginRequest;
import com.online.OnlineShoping.model.User;
import com.online.OnlineShoping.services.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	private static final String LOGIN_SUCCESSFUL = "Login successful!";
	private static final String INVALID_USER = "User does not exist";
	private static final String SUCCESSFUL_REGISTERED = "User registered successfully!";

	@Autowired
	private UserService userService;

	@PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		Optional<User> user = userService.validateUser(request.getUsername(), request.getPassword());
		Map<String, Object> response = new HashMap<>();
		if (user.isPresent()) {
			response.put("message", LOGIN_SUCCESSFUL);
			response.put("user", user.get());
			return ResponseEntity.ok(response);
		} else {
			response.put("message", INVALID_USER);
			return ResponseEntity.ok(response);
		}
	}
	
	@PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
		userService.saveUser(user);

		Map<String, String> response = new HashMap<>();
		response.put("message", SUCCESSFUL_REGISTERED);
		response.put("username", user.getUsername());

		return ResponseEntity.ok(response);
	}
}