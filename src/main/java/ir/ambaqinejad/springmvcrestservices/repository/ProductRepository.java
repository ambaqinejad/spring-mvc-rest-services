package ir.ambaqinejad.springmvcrestservices.repository;

import ir.ambaqinejad.springmvcrestservices.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
