package com.example.myshopmicroservice.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.myshopmicroservice.entity.Product;
import com.example.myshopmicroservice.exception.NoProductFoundException;
import com.example.myshopmicroservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepo;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
//	private final String ORDER_SERVICE_URL="http://localhost:8090/";
	

	
	public List<Product> getAllProducts() {
		return (List<Product>) productRepo.findAll();
	}

	public Product getProductById(int id) {
		if (productRepo.findById(id).isPresent())
			return productRepo.findById(id).get();
		else
			throw new NoProductFoundException("No Product Found");
	}

	
	public Product insertProduct(Product p) {
		return productRepo.save(p);
	}

	public List<Product> insertAllProducts(List<Product> p) {
		for(Product pr: p)
		{
			 productRepo.save(pr);
		}
		return productRepo.findAll();
	}


	public List<Product> getProductByCategory(String p) {
		return productRepo.findByCategory(p);
	}

	
	public Product updateProduct(int id,Product updatedProduct) {
		if(productRepo.existsById(id)) {
			return productRepo.save(updatedProduct);
		}
		else {
			throw new NoProductFoundException("No Product Found");
		}
	}

	
	public Product deleteProduct(int id) {
		Optional<Product> productOptional = productRepo.findById(id);
	    if (productOptional.isPresent()) {
	        Product productToDelete = productOptional.get();
	        productRepo.delete(productToDelete);
	        return productToDelete;
	    } else {
	        throw new NoProductFoundException("No Product Found");
	    }
	}
	
	public void updateProductAvailability(int productId, int quantityChange) {
		Product product=productRepo.findById(productId).orElse(null);
		if(product!= null) {
			int currentAvailability=product.getAvailability();
			int newAvailability=currentAvailability- quantityChange;
			if(newAvailability>=0)
			{
				product.setAvailability(newAvailability);
				productRepo.save(product);
			}
			else {
				throw new RuntimeException("Quantity change exceeds current availability for product with ID: "+productId);
			}
		}
		else {
			throw new RuntimeException("product not found with ID: "+productId);

		}
//		restTemplate.put(ORDER_SERVICE_URL+"updateProduct/"+productId+"/updateAvailableCount/"+quantityChange,null);
	}


	
	

}
