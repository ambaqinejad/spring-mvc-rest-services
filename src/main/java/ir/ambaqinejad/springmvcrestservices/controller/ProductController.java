package ir.ambaqinejad.springmvcrestservices.controller;

import ir.ambaqinejad.springmvcrestservices.model.ProductDTO;
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
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO savedProductDTO = productService.createProduct(productDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/products/" + savedProductDTO.getId().toString());
        return new ResponseEntity<>(savedProductDTO, headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDTO> getAllProducts() {
        return this.productService.getAllProducts();
    }

    /* @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e) {
        System.out.println(e.getMessage());
        return ResponseEntity.notFound().build();
    } */

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public ProductDTO getProductById(@PathVariable("productId") UUID id) {
        log.debug("Get product by id in controller. id: " + id + ".");
        return productService.getProductById(id).orElseThrow(NotFoundException::new);
    }

    @PutMapping("{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable UUID productId, @RequestBody ProductDTO productDTO) {
        ProductDTO updatedProductDTO = productService.updateProduct(productId, productDTO);
        HttpHeaders headers = new HttpHeaders();
        if (updatedProductDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        headers.add("Location", "/api/v1/products/" + updatedProductDTO.getId().toString());
        return new ResponseEntity<>(updatedProductDTO, HttpStatus.OK);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable UUID productId) {
        ProductDTO deletedProductDTO = productService.deleteProduct(productId);
        if (deletedProductDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deletedProductDTO, HttpStatus.OK);
    }

    @PatchMapping("{productId}")
    public ResponseEntity<ProductDTO> updateProductById(@PathVariable UUID productId, @RequestBody ProductDTO productDTO) {
        ProductDTO patchedProductDTO = productService.patchProduct(productId, productDTO);
        if (patchedProductDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patchedProductDTO, HttpStatus.OK);
    }
}
