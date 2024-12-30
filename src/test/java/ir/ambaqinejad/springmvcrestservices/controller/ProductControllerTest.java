package ir.ambaqinejad.springmvcrestservices.controller;

import ir.ambaqinejad.springmvcrestservices.model.Product;
import ir.ambaqinejad.springmvcrestservices.service.ProductService;
import ir.ambaqinejad.springmvcrestservices.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.Is.is;

@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {

    ProductServiceImpl productServiceImpl = new ProductServiceImpl();


    @Autowired
    MockMvc mockMvc;
    @MockitoBean
    ProductService productService;

    @Test
    void createProduct() {
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void getProductById() throws Exception {
        Product product = productServiceImpl.getAllProducts().get(0);
        given(productService.getProductById(product.getId())).willReturn(product);
        mockMvc.perform(get("/api/v1/products/" + product.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(product.getId().toString())))
                .andExpect(jsonPath("$.name", is(product.getName())))
                .andExpect(jsonPath("$.productStyle", is(product.getProductStyle().toString())))
                .andExpect(jsonPath("$.quantityOnHand", is(product.getQuantityOnHand())));
//                .andExpect(jsonPath("$.price", is(product.getPrice())))
//                .andExpect(jsonPath("$.createdDate", is(product.getCreatedDate().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))));
//                .andExpect(jsonPath("$.modifiedDate", is(product.getModifiedDate().toString())));
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void updateProductById() {
    }
}