package com.easipm.orderservice;

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
public class OrderJpaResource {
	
	// @Autowired replaces the need of a constructor for CustomerJpaResource
	@Autowired
    private OrderRepository repository;

	// GET /users
	@GetMapping("/jpa/orders")
	public List<Order> retrieveAllOrders() {
		return repository.findAll();
	}

	// GET /users
	@GetMapping("/jpa/orders/{id}")
	public EntityModel<Order> retrieveOrder(@PathVariable int id) {
		Optional<Order> order = repository.findById(id);
		EntityModel<Order> entityModel = EntityModel.of(order.get());
		return entityModel;
	}

	@DeleteMapping("/jpa/orders/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}

	@PostMapping("/jpa/orders")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		
		Order saveOrder = repository.save(order);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(saveOrder.getId())
						.toUri();   
		
		return ResponseEntity.created(location).build();
	}

}