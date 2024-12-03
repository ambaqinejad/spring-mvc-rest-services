package ir.ambaqinejad.springmvcrestservices.service;

import ir.ambaqinejad.springmvcrestservices.model.Product;

import java.util.UUID;

public interface ProductService {
    Product getProductById(UUID id);
}
