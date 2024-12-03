package ir.ambaqinejad.springmvcrestservices.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Product {
    private UUID id;
    private Integer version;
    private String name;
    private ProductStyle productStyle;
    private Integer quantityOnHand;
    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    Product(UUID id, Integer version, String name, ProductStyle productStyle, Integer quantityOnHand, BigDecimal price, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.version = version;
        this.name = name;
        this.productStyle = productStyle;
        this.quantityOnHand = quantityOnHand;
        this.price = price;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Product)) return false;
        final Product other = (Product) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$version = this.getVersion();
        final Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$productStyle = this.getProductStyle();
        final Object other$productStyle = other.getProductStyle();
        if (this$productStyle == null ? other$productStyle != null : !this$productStyle.equals(other$productStyle))
            return false;
        final Object this$quantityOnHand = this.getQuantityOnHand();
        final Object other$quantityOnHand = other.getQuantityOnHand();
        if (this$quantityOnHand == null ? other$quantityOnHand != null : !this$quantityOnHand.equals(other$quantityOnHand))
            return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$createdDate = this.getCreatedDate();
        final Object other$createdDate = other.getCreatedDate();
        if (this$createdDate == null ? other$createdDate != null : !this$createdDate.equals(other$createdDate))
            return false;
        final Object this$modifiedDate = this.getModifiedDate();
        final Object other$modifiedDate = other.getModifiedDate();
        if (this$modifiedDate == null ? other$modifiedDate != null : !this$modifiedDate.equals(other$modifiedDate))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Product;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $version = this.getVersion();
        result = result * PRIME + ($version == null ? 43 : $version.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $productStyle = this.getProductStyle();
        result = result * PRIME + ($productStyle == null ? 43 : $productStyle.hashCode());
        final Object $quantityOnHand = this.getQuantityOnHand();
        result = result * PRIME + ($quantityOnHand == null ? 43 : $quantityOnHand.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $createdDate = this.getCreatedDate();
        result = result * PRIME + ($createdDate == null ? 43 : $createdDate.hashCode());
        final Object $modifiedDate = this.getModifiedDate();
        result = result * PRIME + ($modifiedDate == null ? 43 : $modifiedDate.hashCode());
        return result;
    }

    public String toString() {
        return "Product(id=" + this.getId() + ", version=" + this.getVersion() + ", name=" + this.getName() + ", productStyle=" + this.getProductStyle() + ", quantityOnHand=" + this.getQuantityOnHand() + ", price=" + this.getPrice() + ", createdDate=" + this.getCreatedDate() + ", modifiedDate=" + this.getModifiedDate() + ")";
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
