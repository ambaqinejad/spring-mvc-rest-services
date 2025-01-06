package ir.ambaqinejad.springmvcrestservices.service;

import ir.ambaqinejad.springmvcrestservices.model.ProductDTO;
import ir.ambaqinejad.springmvcrestservices.model.ProductStyle;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ProductServiceImpl.class);
    private Map<UUID, ProductDTO> products;

    public ProductServiceImpl() {
        this.products = new HashMap<>();
        ProductDTO productDTO1 = ProductDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Mobile")
                .productStyle(ProductStyle.MEDIUM)
                .price(new BigDecimal("99.20"))
                .quantityOnHand(50)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        ProductDTO productDTO2 = ProductDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("PS5")
                .productStyle(ProductStyle.X_LARGE)
                .price(new BigDecimal("54.20"))
                .quantityOnHand(50)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        ProductDTO productDTO3 = ProductDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Laptop")
                .productStyle(ProductStyle.S_SMALL)
                .price(new BigDecimal("152.10"))
                .quantityOnHand(20)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        products.put(productDTO1.getId(), productDTO1);
        products.put(productDTO2.getId(), productDTO2);
        products.put(productDTO3.getId(), productDTO3);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Optional<ProductDTO> getProductById(UUID id) {
        log.debug("Get product by id in service. id: " + id.toString());
        return Optional.of(products.get(id));
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductDTO savedProductDTO = ProductDTO.builder()
                .id(UUID.randomUUID())
                .version(productDTO.getVersion())
                .name(productDTO.getName())
                .productStyle(productDTO.getProductStyle())
                .price(productDTO.getPrice())
                .quantityOnHand(productDTO.getQuantityOnHand())
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();
        products.put(savedProductDTO.getId(), savedProductDTO);
        return savedProductDTO;
    }

    @Override
    public ProductDTO updateProduct(UUID productId, ProductDTO productDTO) {
        ProductDTO existing = products.get(productId);
        if (existing == null) {
            return null;
        }
        existing.setName(productDTO.getName());
        existing.setPrice(productDTO.getPrice());
        existing.setQuantityOnHand(productDTO.getQuantityOnHand());
        existing.setModifiedDate(LocalDateTime.now());
        existing.setProductStyle(productDTO.getProductStyle());
        products.put(existing.getId(), existing);
        return existing;
    }

    @Override
    public ProductDTO deleteProduct(UUID productId) {
        ProductDTO deletedProductDTO = products.get(productId);
        if (deletedProductDTO == null) {
            return null;
        }
        products.remove(productId);
        return deletedProductDTO;
    }

    @Override
    public ProductDTO patchProduct(UUID id, ProductDTO productDTO) {
        ProductDTO existedProductDTO = products.get(id);
        if (existedProductDTO == null) {
            return null;
        }
        if (StringUtils.hasText(productDTO.getName())) {
            existedProductDTO.setName(productDTO.getName());
        }
        if (productDTO.getProductStyle() != null) {
            existedProductDTO.setProductStyle(productDTO.getProductStyle());
        }
        if (productDTO.getPrice() != null) {
            existedProductDTO.setPrice(productDTO.getPrice());
        }
        if (productDTO.getQuantityOnHand() != null) {
            existedProductDTO.setQuantityOnHand(productDTO.getQuantityOnHand());
        }
        existedProductDTO.setModifiedDate(LocalDateTime.now());
        products.put(id, existedProductDTO); // this is not necessary because it changes with pointer
        return existedProductDTO;
    }
}
