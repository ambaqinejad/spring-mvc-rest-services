package ir.ambaqinejad.springmvcrestservices.controller;

import ir.ambaqinejad.springmvcrestservices.model.Product;
import ir.ambaqinejad.springmvcrestservices.service.ProductService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/api/v1/products")
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    public Product getProductById(UUID id) {
        log.debug("Get product by id in controller. id: " + id);
        return productService.getProductById(id);
    }
}
