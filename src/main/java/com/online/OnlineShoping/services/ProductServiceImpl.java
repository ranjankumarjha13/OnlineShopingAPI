package com.online.OnlineShoping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.OnlineShoping.model.Product;
import com.online.OnlineShoping.repositry.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;


	@Override
	public List<Product> getProductDetails() {
		List<Product> productList=productRepository.findAll();
		return productList;
	}

}
