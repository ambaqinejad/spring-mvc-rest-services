package ir.ambaqinejad.springmvcrestservices.service;

import ir.ambaqinejad.springmvcrestservices.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProducts();

    Optional<Product> getProductById(UUID id);

    Product createProduct(Product product);

    Product updateProduct(UUID productId, Product product);

    Product deleteProduct(UUID productId);

    Product patchProduct(UUID id, Product product);
}
