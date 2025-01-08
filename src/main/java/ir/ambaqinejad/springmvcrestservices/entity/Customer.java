package ir.ambaqinejad.springmvcrestservices.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Customer {
    @Id
    // @GeneratedValue(generator = "UUID")
    // @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @UuidGenerator
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false, unique = true)
    private UUID id;
    private String name;
    @Version
    private Integer version;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;

    public Customer(UUID id, String name, Integer version, LocalDateTime createdDate, LocalDateTime updateDate) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
    }

    public Customer() {
    }

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getVersion() {
        return this.version;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public LocalDateTime getUpdateDate() {
        return this.updateDate;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public static class CustomerBuilder {
        private UUID id;
        private String name;
        private Integer version;
        private LocalDateTime createdDate;
        private LocalDateTime updateDate;

        CustomerBuilder() {
        }

        public CustomerBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder version(Integer version) {
            this.version = version;
            return this;
        }

        public CustomerBuilder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public CustomerBuilder updateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Customer build() {
            return new Customer(this.id, this.name, this.version, this.createdDate, this.updateDate);
        }

        public String toString() {
            return "Customer.CustomerBuilder(id=" + this.id + ", name=" + this.name + ", version=" + this.version + ", createdDate=" + this.createdDate + ", updateDate=" + this.updateDate + ")";
        }
    }
}
