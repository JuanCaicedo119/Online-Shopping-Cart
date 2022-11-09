package com.easipm.categoryservice;

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
public class CategoryJpaResource {
	
	// @Autowired replaces the need of a constructor for CategoryJpaResource
	@Autowired
    private CategoryRepository repository;

	@GetMapping("/jpa/categories")
	public List<Category> retrieveAllCategories() {
		return repository.findAll();
	}

	@GetMapping("/jpa/categories/{id}")
	public EntityModel<Category> retrieveCategory(@PathVariable int id) {
		Optional<Category> category = repository.findById(id);
		EntityModel<Category> entityModel = EntityModel.of(category.get());		
		return entityModel;
	}

	@DeleteMapping("/jpa/categories/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}

	@PostMapping("/jpa/categories")
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		
		Category saveCategory = repository.save(category);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(saveCategory.getId())
						.toUri();   
		
		return ResponseEntity.created(location).build();
	}

}
