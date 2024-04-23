package com.example.myshopmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myshopmicroservice.entity.Product;
import com.example.myshopmicroservice.service.ProductService;

@RestController
@CrossOrigin(origins="http://localhost:3000",allowedHeaders="*")
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	

	@GetMapping()
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@PutMapping()
	public Product updateProduct(@RequestParam int id,@RequestBody Product p)
	{
		return productService.updateProduct(id, p);
	}
	
	@PostMapping()
	public Product insertProducts(@RequestBody Product p){
		return productService.insertProduct(p);
	}
	
	@PostMapping("/insertAll")
	public List<Product> insertAllProducts(@RequestBody List<Product> p)
	{
		return productService.insertAllProducts(p);
	}
	
	@PutMapping("/updateProduct/{productId}/updateAvailableCount/{quantityChange}")
	public ResponseEntity<String> updateProductAvailableCount(@PathVariable int productId,@PathVariable int quantityChange)
	{
		productService.updateProductAvailability(productId, quantityChange);
		return ResponseEntity.ok("Product availability updates successfully");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int id){
		Product product=productService.deleteProduct(id);
		if(product !=null)
		{
			return ResponseEntity.noContent().build();
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category){
		List<Product> products=productService.getProductByCategory(category);
		return ResponseEntity.ok(products);
	}
	
	
	
		
}
