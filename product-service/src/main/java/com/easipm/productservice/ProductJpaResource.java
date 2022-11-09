package com.easipm.productservice;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class ProductJpaResource {
	
	// @Autowired replaces the need of a constructor for CustomerJpaResource
	@Autowired
    private ProductRepository repository;

	// GET /users
	@GetMapping("/jpa/products")
	public List<Product> retrieveAllProducts() {
		return repository.findAll();
	}

	// GET /users
	@GetMapping("/jpa/products/{id}")
	public EntityModel<Product> retrieveProduct(@PathVariable int id) {
		Optional<Product> product = repository.findById(id);
		EntityModel<Product> entityModel = EntityModel.of(product.get());
		return entityModel;
	}

	@DeleteMapping("/jpa/products/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}

	@PostMapping("/jpa/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		
		Product saveProduct = repository.save(product);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(saveProduct.getId())
						.toUri();   
		
		return ResponseEntity.created(location).build();
	}

}