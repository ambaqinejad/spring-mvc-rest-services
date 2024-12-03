package ir.ambaqinejad.springmvcrestservices.controller;

import ir.ambaqinejad.springmvcrestservices.model.Product;
import ir.ambaqinejad.springmvcrestservices.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@AllArgsConstructor
@Slf4j
public class ProductController {
    private ProductService productService;

    public Product getProductById(UUID id) {
        log.debug("Get product by id in controller. id: " + id);
        return productService.getProductById(id);
    }
}
