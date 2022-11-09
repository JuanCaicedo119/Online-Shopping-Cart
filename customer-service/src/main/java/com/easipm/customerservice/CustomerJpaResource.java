package com.easipm.customerservice;
import java.net.URI;
import java.util.Arrays;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netflix.discovery.converters.Auto;


@RestController
public class CustomerJpaResource {
	
	// @Autowired replaces the need of a constructor for CustomerJpaResource
	@Autowired
    private CustomerRepository repository;

	
	@GetMapping("/jpa/customers")
	public List<Customer> retrieveAllCustomers() {
		return repository.findAll();
	}
	
	@GetMapping("/jpa/customers/{id}")
	public EntityModel<Customer> retrieveCustomer(@PathVariable int id) {
		Optional<Customer> customer = repository.findById(id);
		if(user.isEmpty())
			throw new CustomerNotFoundException("id: "+ id);
		EntityModel<Customer> entityModel = EntityModel.of(customer.get());
		return entityModel;
	}

	@DeleteMapping("/jpa/customers/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@PostMapping("/jpa/customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		
		Customer saveCustomer = repository.save(customer);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(saveCustomer.getId())
		.toUri();   
		
		return ResponseEntity.created(location).build();
	}
	//---------------------------------------------------------------------------------------//
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/jpa/orders")
	public List<Object> retrieveAllOrders() {
		Object[] orders = restTemplate.getForObject("http://order-service/jpa/orders", Object[].class);
		return Arrays.asList(orders);
	}

	// @GetMapping("/jpa/orders")
	// public List<Order> retrieveAllOrders() {
	// 	restTemplate.getForObject("http://order-service/orders", Object[].class);
	// }
	
}