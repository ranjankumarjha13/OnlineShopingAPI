package com.online.OnlineShoping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.OnlineShoping.constans.Constants;
import com.online.OnlineShoping.model.Product;
import com.online.OnlineShoping.model.User;
import com.online.OnlineShoping.services.ProductService;
import com.online.OnlineShoping.services.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = Constants.FRONTEND_URL_CROSS_ORIGIN)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	

	@GetMapping(value = "/fetchusers", produces = "application/json")
	public ResponseEntity<?> fetchAllUsers() {
		List<User> userList = userService.fetchAllUser();
		if(!userList.isEmpty()) {
			return ResponseEntity.ok(userList);
		}
		return ResponseEntity.ok().body(Constants.USER_NOT_FOUND);
		
	}
	@GetMapping(value = "/fetchproduct", produces = "application/json")
	public ResponseEntity<?> fetchAllProduct() {
		 List<Product> productList=productService.getProductDetails();
		 System.out.println("Product related changes for Testing");
		if(!productList.isEmpty()) {
			return ResponseEntity.ok(productList);
		}
		return ResponseEntity.ok().body(Constants.PRODUCT_NOT_FOUND);
		
	}

}
