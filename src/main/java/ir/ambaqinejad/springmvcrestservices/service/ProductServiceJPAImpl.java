package ir.ambaqinejad.springmvcrestservices.service;

import ir.ambaqinejad.springmvcrestservices.entity.Product;
import ir.ambaqinejad.springmvcrestservices.mapper.ProductMapper;
import ir.ambaqinejad.springmvcrestservices.model.ProductDTO;
import ir.ambaqinejad.springmvcrestservices.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class ProductServiceJPAImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::productToProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> getProductById(UUID id) {
        return Optional
                .ofNullable(
                        productMapper.productToProductDTO(productRepository.findById(id)
                                .orElse(null))
                );
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.productDTOToProduct(productDTO);
        return productMapper.productToProductDTO(productRepository.save(product));
    }

    @Override
    public ProductDTO updateProduct(UUID productId, ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO deleteProduct(UUID productId) {
        return null;
    }

    @Override
    public ProductDTO patchProduct(UUID id, ProductDTO productDTO) {
        return null;
    }
}
