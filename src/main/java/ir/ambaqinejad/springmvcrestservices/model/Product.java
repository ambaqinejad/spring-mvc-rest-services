package ir.ambaqinejad.springmvcrestservices.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Product {
    private UUID id;
    private Integer version;
    private String name;
    private ProductStyle productStyle;
    private Integer quantityOnHand;
    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
