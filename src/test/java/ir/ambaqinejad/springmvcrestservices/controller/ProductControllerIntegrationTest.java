package ir.ambaqinejad.springmvcrestservices.controller;

import ir.ambaqinejad.springmvcrestservices.entity.Product;
import ir.ambaqinejad.springmvcrestservices.mapper.ProductMapper;
import ir.ambaqinejad.springmvcrestservices.model.ProductDTO;
import ir.ambaqinejad.springmvcrestservices.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductControllerIntegrationTest {

    @Autowired
    ProductController productController;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;

    @Rollback
    @Transactional
    @Test
    void createProduct() {
        ProductDTO productDTO = ProductDTO.builder()
                .name("New Product")
                .build();
        ResponseEntity<ProductDTO> responseEntity = productController.createProduct(productDTO);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
        assertThat(responseEntity.getHeaders().getLocation()).isNotNull();
        String locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/")[4];
        UUID savedUUID = UUID.fromString(locationUUID);
        Optional<Product> product = productRepository.findById(savedUUID);
        assertThat(product).isPresent();
    }

    @Test
    void getAllProducts() {
        List<ProductDTO> products = productController.getAllProducts();
        assertThat(products.size()).isEqualTo(2);
        assertThat(products.getFirst().getName()).isEqualTo("first");
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
        Product product = productRepository.findAll().getFirst();
        ProductDTO productDTO = productController.getProductById(product.getId());
        assertThat(productDTO).isNotNull();
        assertThat(productDTO.getName()).isEqualTo(product.getName());
    }

    @Test
    void getProductByIdNotFoundException() {
        assertThrows(NotFoundException.class, () -> productController.getProductById(UUID.randomUUID()));
    }

    @Test
    void updateProduct() {
        Product product = productRepository.findAll().getFirst();
        ProductDTO productDTO = productMapper.productToProductDTO(product);
        productDTO.setId(null);
        productDTO.setVersion(null);
        productDTO.setName("Updated Product");

        ResponseEntity<ProductDTO> updatedProduct = productController.updateProduct(product.getId(), productDTO);
        assertThat(updatedProduct.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));

        if (productRepository.findById(product.getId()).isPresent()) {
            Product product2 = productRepository.findById(product.getId()).get();
            assertThat(product2.getName()).isEqualTo("Updated Product");
        }
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void updateProductById() {
    }
}