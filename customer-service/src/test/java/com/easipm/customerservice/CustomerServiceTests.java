package com.easipm.customerservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CustomerServiceTests {
    @Autowired private CustomerRepository repo;

    @Test
    public void testCreateNew() {
        Customer customer = new Customer();
        customer.setFirstName("Cory");
        customer.setLastName("Porter");
        customer.setPhoneNumber("6574854889");

        Customer savedCustomer = repo.save(customer);

        Assertions.assertThat(savedCustomer).isNotNull();
        Assertions.assertThat(savedCustomer.getId()).isGreaterThan(0);
    }

    @Test
    public void testRetrieveAll() {
        Iterable<Customer> customers = repo.findAll();
        Assertions.assertThat(customers).hasSizeGreaterThan(0);

        for(Customer customer : customers)
            System.out.println(customer);
    }

    @Test
    public void testRetrieve() {
        Integer customerId = 2;
        Optional<Customer> optionalCustomer = repo.findById(customerId);
        Assertions.assertThat(optionalCustomer).isPresent();
        System.out.println(optionalCustomer.get());
    }

    @Test
    public void testDelete() {
        Integer customerId = 2;
        Optional<Customer> optionalCustomer = repo.findById(customerId);
        Assertions.assertThat(optionalCustomer).isNotPresent();
    }
}