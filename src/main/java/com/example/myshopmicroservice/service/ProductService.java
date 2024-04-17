package com.example.myshopmicroservice.service;

import java.util.List;

import com.example.myshopmicroservice.entity.Product;


public interface ProductService {
	
public List<Product> getAllProducts();
	
	public Product getProductById(int id);
	
	public Product insertProduct(Product p);
	
	public void updateProductAvailability(int productId,int quantityChange);
	
	public List<Product> insertAllProducts(List<Product> p);

	public List<Product> getProductByCategory(String p);
	
	public Product updateProduct(int id,Product updatedProduct);
	
	public Product deleteProduct(int id);
	

}
