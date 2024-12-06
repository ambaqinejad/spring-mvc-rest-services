package ir.ambaqinejad.springmvcrestservices.service;

import ir.ambaqinejad.springmvcrestservices.model.Product;
import ir.ambaqinejad.springmvcrestservices.model.ProductStyle;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ProductServiceImpl.class);
    private Map<UUID, Product> products;

    public ProductServiceImpl() {
        this.products = new HashMap<>();
        Product product1 = Product.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Mobile")
                .productStyle(ProductStyle.MEDIUM)
                .price(new BigDecimal("99.20"))
                .quantityOnHand(50)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        Product product2 = Product.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("PS5")
                .productStyle(ProductStyle.X_LARGE)
                .price(new BigDecimal("54.20"))
                .quantityOnHand(50)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        Product product3 = Product.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Laptop")
                .productStyle(ProductStyle.S_SMALL)
                .price(new BigDecimal("152.10"))
                .quantityOnHand(20)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        products.put(product1.getId(), product1);
        products.put(product2.getId(), product2);
        products.put(product3.getId(), product3);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(UUID id) {
        log.debug("Get product by id in service. id: " + id.toString());
        return this.products.get(id);
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct = Product.builder()
                .id(UUID.randomUUID())
                .version(product.getVersion())
                .name(product.getName())
                .productStyle(product.getProductStyle())
                .price(product.getPrice())
                .quantityOnHand(product.getQuantityOnHand())
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();
        products.put(savedProduct.getId(), savedProduct);
        return savedProduct;
    }

    @Override
    public Product updateProduct(UUID productId, Product product) {
        Product existing = products.get(productId);
        if (existing == null) {
            return null;
        }
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setQuantityOnHand(product.getQuantityOnHand());
        existing.setModifiedDate(LocalDateTime.now());
        products.put(existing.getId(), existing);
        return existing;
    }

    @Override
    public Product deleteProduct(UUID productId) {
        Product deletedProduct = products.get(productId);
        if (deletedProduct == null) {
            return null;
        }
        products.remove(productId);
        return deletedProduct;
    }
}
