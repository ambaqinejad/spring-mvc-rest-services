package ir.ambaqinejad.springmvcrestservices.entity;

import ir.ambaqinejad.springmvcrestservices.model.ProductStyle;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Product {
    @Id
    @UuidGenerator
    @Column(length = 36, nullable = false, updatable = false, unique = true)
    private UUID id;
    @Version
    private Integer version;
    private String name;
    private ProductStyle productStyle;
    private Integer quantityOnHand;
    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Product(UUID id, Integer version, String name, ProductStyle productStyle, Integer quantityOnHand, BigDecimal price, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.version = version;
        this.name = name;
        this.productStyle = productStyle;
        this.quantityOnHand = quantityOnHand;
        this.price = price;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Product() {
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public UUID getId() {
        return this.id;
    }

    public Integer getVersion() {
        return this.version;
    }

    public String getName() {
        return this.name;
    }

    public ProductStyle getProductStyle() {
        return this.productStyle;
    }

    public Integer getQuantityOnHand() {
        return this.quantityOnHand;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return this.modifiedDate;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductStyle(ProductStyle productStyle) {
        this.productStyle = productStyle;
    }

    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public static class ProductBuilder {
        private UUID id;
        private Integer version;
        private String name;
        private ProductStyle productStyle;
        private Integer quantityOnHand;
        private BigDecimal price;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;

        ProductBuilder() {
        }

        public ProductBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public ProductBuilder version(Integer version) {
            this.version = version;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder productStyle(ProductStyle productStyle) {
            this.productStyle = productStyle;
            return this;
        }

        public ProductBuilder quantityOnHand(Integer quantityOnHand) {
            this.quantityOnHand = quantityOnHand;
            return this;
        }

        public ProductBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductBuilder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public ProductBuilder modifiedDate(LocalDateTime modifiedDate) {
            this.modifiedDate = modifiedDate;
            return this;
        }

        public Product build() {
            return new Product(this.id, this.version, this.name, this.productStyle, this.quantityOnHand, this.price, this.createdDate, this.modifiedDate);
        }

        public String toString() {
            return "Product.ProductBuilder(id=" + this.id + ", version=" + this.version + ", name=" + this.name + ", productStyle=" + this.productStyle + ", quantityOnHand=" + this.quantityOnHand + ", price=" + this.price + ", createdDate=" + this.createdDate + ", modifiedDate=" + this.modifiedDate + ")";
        }
    }
}
