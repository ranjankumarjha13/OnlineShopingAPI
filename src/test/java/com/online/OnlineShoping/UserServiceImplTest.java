package com.online.OnlineShoping;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import com.online.OnlineShoping.model.User;
import com.online.OnlineShoping.repositry.UserRepository;
import com.online.OnlineShoping.services.UserServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	private User testUser;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this); // Initialize mocks
		testUser = new User();
		testUser.setId("1");
		testUser.setUsername("ranjan@test.com");
		testUser.setPassword("password123");
	}

	@Test
	void testValidateUser_ValidCredentials() {
		when(userRepository.findByUsernameAndPassword("ranjan@test.com", "password123"))
				.thenReturn(Optional.of(testUser));

		Optional<User> result = userService.validateUser("ranjan@test.com", "password123");

		assertTrue(result.isPresent());
		assertEquals("ranjan@test.com", result.get().getUsername());
		verify(userRepository, times(1)).findByUsernameAndPassword("ranjan@test.com", "password123");
	}

	@Test
	void testValidateUser_InvalidCredentials() {
		when(userRepository.findByUsernameAndPassword("wrong", "wrong")).thenReturn(Optional.empty());

		Optional<User> result = userService.validateUser("wrong", "wrong");
		assertFalse(result.isPresent());
		verify(userRepository, times(1)).findByUsernameAndPassword("wrong", "wrong");
	}

	@Test
	void testSaveUser() {
		when(userRepository.save(testUser)).thenReturn(testUser);
		User savedUser = userService.saveUser(testUser);
		assertNotNull(savedUser);
		assertEquals("ranjan@test.com", savedUser.getUsername());
		verify(userRepository, times(1)).save(testUser);
	}
}
