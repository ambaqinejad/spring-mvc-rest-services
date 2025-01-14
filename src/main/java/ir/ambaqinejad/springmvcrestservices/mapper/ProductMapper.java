package ir.ambaqinejad.springmvcrestservices.mapper;

import ir.ambaqinejad.springmvcrestservices.entity.Product;
import ir.ambaqinejad.springmvcrestservices.model.ProductDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    Product productDTOToProduct(ProductDTO productDTO);
    ProductDTO productToProductDTO(Product product);
}
