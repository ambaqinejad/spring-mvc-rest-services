package ir.ambaqinejad.springmvcrestservices.bootstrap;

import ir.ambaqinejad.springmvcrestservices.entity.Product;
import ir.ambaqinejad.springmvcrestservices.model.ProductStyle;
import ir.ambaqinejad.springmvcrestservices.repository.CustomerRepository;
import ir.ambaqinejad.springmvcrestservices.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadProductData();
    }

    private void loadProductData() {
        if (productRepository.count() == 0){
            Product product1 = Product.builder()
                    .name("first")
                    .productStyle(ProductStyle.MEDIUM)
                    .price(new BigDecimal("12.99"))
                    .quantityOnHand(122)
                    .createdDate(LocalDateTime.now())
                    .modifiedDate(LocalDateTime.now())
                    .build();

            Product product2 = Product.builder()
                    .name("second")
                    .productStyle(ProductStyle.LARGE)
                    .price(new BigDecimal("11.99"))
                    .quantityOnHand(392)
                    .createdDate(LocalDateTime.now())
                    .modifiedDate(LocalDateTime.now())
                    .build();


            productRepository.save(product1);
            productRepository.save(product2);
        }

    }
}
