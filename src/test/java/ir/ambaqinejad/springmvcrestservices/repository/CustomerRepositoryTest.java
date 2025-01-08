package ir.ambaqinejad.springmvcrestservices.repository;

import ir.ambaqinejad.springmvcrestservices.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void saveCustomerTest() {
        Customer customer = customerRepository.save(Customer.builder().name("New Customer").build());
        assertEquals(customer.getName(), "New Customer");
        assertThat(customer).isNotNull();
    }
}