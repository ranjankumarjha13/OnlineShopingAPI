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

import com.online.OnlineShoping.constans.Constants;
import com.online.OnlineShoping.model.LoginRequest;
import com.online.OnlineShoping.model.User;
import com.online.OnlineShoping.services.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = Constants.FRONTEND_URL_CROSS_ORIGIN)
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> validateUser(@RequestBody LoginRequest request) {
		Optional<User> user = userService.validateUser(request.getUsername(), request.getPassword());
		Map<String, Object> response = new HashMap<>();
		if (user.isPresent()) {
			response.put("message", Constants.LOGIN_SUCCESSFUL);
			response.put("user", user.get());
			return ResponseEntity.ok(response);
		} else {
			response.put("message", Constants.INVALID_USER);
			return ResponseEntity.ok(response);
		}
	}
	
	@PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, String>> createUser(@RequestBody User user) {
		userService.saveUser(user);

		Map<String, String> response = new HashMap<>();
		response.put("message", Constants.SUCCESSFUL_REGISTERED);
		response.put("username", user.getUsername());

		return ResponseEntity.ok(response);
	}
}