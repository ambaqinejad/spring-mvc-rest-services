package ir.ambaqinejad.springmvcrestservices.controller;

import ir.ambaqinejad.springmvcrestservices.entity.Product;
import ir.ambaqinejad.springmvcrestservices.model.ProductDTO;
import ir.ambaqinejad.springmvcrestservices.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductControllerIntegrationTest {

    @Autowired
    ProductController productController;
    @Autowired
    ProductRepository productRepository;

    @Test
    void createProduct() {
    }

    @Test
    void getAllProducts() {
        List<ProductDTO> products = productController.getAllProducts();
        assertThat(products.size()).isEqualTo(2);
        assertThat(products.get(0).getName()).isEqualTo("first");
    }

    @Rollback
    @Transactional
    @Test
    void getAllProductsEmpty() {
        productRepository.deleteAll();
        List<ProductDTO> products = productController.getAllProducts();
        assertThat(products.size()).isEqualTo(0);
    }

    @Test
    void getProductById() {
        Product product = productRepository.findAll().get(0);
        ProductDTO productDTO = productController.getProductById(product.getId());
        assertThat(productDTO).isNotNull();
        assertThat(productDTO.getName()).isEqualTo(product.getName());
    }

    @Test
    void getProductByIdNotFoundException() {
        assertThrows(NotFoundException.class, () -> {
            productController.getProductById(UUID.randomUUID());
        });
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void updateProductById() {
    }
}