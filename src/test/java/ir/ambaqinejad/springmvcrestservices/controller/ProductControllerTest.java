package ir.ambaqinejad.springmvcrestservices.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ambaqinejad.springmvcrestservices.model.Product;
import ir.ambaqinejad.springmvcrestservices.service.ProductService;
import ir.ambaqinejad.springmvcrestservices.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.Is.is;
import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {
    ProductServiceImpl productServiceImpl;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @MockitoBean
    ProductService productService;

    @Captor
    ArgumentCaptor<Product> productCaptor;
    @Captor
    ArgumentCaptor<UUID> uuidCaptor;

    @BeforeEach
    void setUp() {
        productServiceImpl = new ProductServiceImpl();
    }

    @Test
    void createProduct() throws Exception {
        // ObjectMapper mapper = new ObjectMapper();
        // mapper.findAndRegisterModules();
        Product product = productServiceImpl.getAllProducts().get(0);
        product.setId(null);
        product.setVersion(null);
        given(productService.createProduct(any(Product.class))).willReturn(productServiceImpl.getAllProducts().get(1));
        mockMvc.perform(post("/api/v1/products")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(product)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
        // System.out.println(mapper.writeValueAsString(product));
    }

    @Test
    void getAllProducts() throws Exception {
        given(productService.getAllProducts()).willReturn(productServiceImpl.getAllProducts());
        mockMvc.perform(get("/api/v1/products")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(3)));
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
//                .andEx pect(jsonPath("$.modifiedDate", is(product.getModifiedDate().toString())));
    }

    @Test
    void updateProduct() throws Exception {
        Product product = productServiceImpl.getAllProducts().get(0);
        mockMvc.perform(put("/api/v1/products/" + product.getId())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(product)));
        verify(productService).updateProduct(any(UUID.class), any(Product.class));
    }

    @Test
    void deleteProduct() throws Exception {
        Product product = productServiceImpl.getAllProducts().get(0);
        mockMvc.perform(delete("/api/v1/products/" + product.getId())
                .accept(MediaType.APPLICATION_JSON));
        ArgumentCaptor<UUID> uuidCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(productService).deleteProduct(uuidCaptor.capture());
        assertThat(product.getId()).isEqualTo(uuidCaptor.getValue());
    }

    @Test
    void deleteProductIfNotExists() throws Exception {
        UUID uuid = UUID.randomUUID();
        mockMvc.perform(delete("/api/v1/products/" + uuid)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
        ArgumentCaptor<UUID> uuidCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(productService).deleteProduct(uuidCaptor.capture());
        assertThat(uuidCaptor.getValue()).isEqualTo(uuid);
    }

    @Test
    void deleteProductIfExists() throws Exception {
        Product product = productServiceImpl.getAllProducts().get(0);
        given(productService.deleteProduct(product.getId())).willReturn(product);
        mockMvc.perform(delete("/api/v1/products/" + product.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(product.getId().toString())));
        ArgumentCaptor<UUID> uuidArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(productService).deleteProduct(uuidArgumentCaptor.capture());
        assertThat(uuidArgumentCaptor.getValue()).isEqualTo(product.getId());
    }

    @Test
    void updateProductById() throws Exception {
        Product product = productServiceImpl.getAllProducts().get(0);
        Map<String, Object> productMap = new HashMap<>();
        productMap.put("name", "new name");
        mockMvc.perform(patch("/api/v1/products/" + product.getId())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(productMap)))
                .andExpect(status().isNotFound());
        verify(productService).patchProduct(uuidCaptor.capture(), productCaptor.capture());
        assertThat(uuidCaptor.getValue()).isEqualTo(product.getId());
        assertThat(productCaptor.getValue().getName()).isEqualTo(productMap.get("name"));
    }

    @Test
    void getProductByIdNotFound() throws Exception {
        given(productService.getProductById(any(UUID.class))).willThrow(NotFoundException.class);
        mockMvc.perform(get("/api/v1/products/" + UUID.randomUUID()))
                .andExpect(status().isNotFound());
    }
}