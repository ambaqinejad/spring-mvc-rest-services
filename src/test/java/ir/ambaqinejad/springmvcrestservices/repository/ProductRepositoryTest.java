package ir.ambaqinejad.springmvcrestservices.repository;

import ir.ambaqinejad.springmvcrestservices.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testSaveProduct() {
        Product product = productRepository.save(Product.builder().name("My Product").build());
        assertThat(product.getName()).isEqualTo("My Product");
        assertThat(product).isNotNull();
        assertThat(product.getId()).isNotNull();
        assertNotNull(product);
    }
}