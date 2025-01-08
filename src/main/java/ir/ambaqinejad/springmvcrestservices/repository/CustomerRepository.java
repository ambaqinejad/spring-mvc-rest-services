package ir.ambaqinejad.springmvcrestservices.repository;

import ir.ambaqinejad.springmvcrestservices.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
