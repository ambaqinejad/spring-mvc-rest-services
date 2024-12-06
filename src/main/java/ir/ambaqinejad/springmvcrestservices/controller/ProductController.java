package ir.ambaqinejad.springmvcrestservices.controller;

import ir.ambaqinejad.springmvcrestservices.model.Product;
import ir.ambaqinejad.springmvcrestservices.service.ProductService;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.createProduct(product);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/products/" + savedProduct.getId().toString());
        return new ResponseEntity<>(savedProduct, headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("productId") UUID id) {
        log.debug("Get product by id in controller. id: " + id + ".");
        return productService.getProductById(id);
    }

    @PutMapping("{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable UUID productId, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(productId, product);
        HttpHeaders headers = new HttpHeaders();
        if (updatedProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        headers.add("Location", "/api/v1/products/" + updatedProduct.getId().toString());
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable UUID productId) {
        Product deletedProduct = productService.deleteProduct(productId);
        if (deletedProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
    }
}
