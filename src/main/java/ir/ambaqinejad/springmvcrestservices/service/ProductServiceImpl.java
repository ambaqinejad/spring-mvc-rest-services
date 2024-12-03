package ir.ambaqinejad.springmvcrestservices.service;

import ir.ambaqinejad.springmvcrestservices.model.Product;
import ir.ambaqinejad.springmvcrestservices.model.ProductStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(UUID id) {
        log.debug("Get product by id in service. id: " + id.toString());
        return Product.builder()
                .id(id)
                .version(1)
                .name("Mobile")
                .productStyle(ProductStyle.MEDIUM)
                .price(new BigDecimal("99.20"))
                .quantityOnHand(50)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();
    }
}
