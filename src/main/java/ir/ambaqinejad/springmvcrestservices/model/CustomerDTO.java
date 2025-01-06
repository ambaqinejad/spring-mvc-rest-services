package ir.ambaqinejad.springmvcrestservices.model;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
public class CustomerDTO {

    private String name;
    private UUID id;
    private Integer version;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;

    CustomerDTO(String name, UUID id, Integer version, LocalDateTime createdDate, LocalDateTime updateDate) {
        this.name = name;
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
    }

    public static CustomerDTOBuilder builder() {
        return new CustomerDTOBuilder();
    }

    public String getName() {
        return this.name;
    }

    public UUID getId() {
        return this.id;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CustomerDTO)) return false;
        final CustomerDTO other = (CustomerDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$version = this.getVersion();
        final Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) return false;
        final Object this$createdDate = this.getCreatedDate();
        final Object other$createdDate = other.getCreatedDate();
        if (this$createdDate == null ? other$createdDate != null : !this$createdDate.equals(other$createdDate))
            return false;
        final Object this$updateDate = this.getUpdateDate();
        final Object other$updateDate = other.getUpdateDate();
        if (this$updateDate == null ? other$updateDate != null : !this$updateDate.equals(other$updateDate))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CustomerDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $version = this.getVersion();
        result = result * PRIME + ($version == null ? 43 : $version.hashCode());
        final Object $createdDate = this.getCreatedDate();
        result = result * PRIME + ($createdDate == null ? 43 : $createdDate.hashCode());
        final Object $updateDate = this.getUpdateDate();
        result = result * PRIME + ($updateDate == null ? 43 : $updateDate.hashCode());
        return result;
    }

    public String toString() {
        return "CustomerDTO(name=" + this.getName() + ", id=" + this.getId() + ", version=" + this.getVersion() + ", createdDate=" + this.getCreatedDate() + ", updateDate=" + this.getUpdateDate() + ")";
    }

    public static class CustomerDTOBuilder {
        private String name;
        private UUID id;
        private Integer version;
        private LocalDateTime createdDate;
        private LocalDateTime updateDate;

        CustomerDTOBuilder() {
        }

        public CustomerDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CustomerDTOBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public CustomerDTOBuilder version(Integer version) {
            this.version = version;
            return this;
        }

        public CustomerDTOBuilder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public CustomerDTOBuilder updateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public CustomerDTO build() {
            return new CustomerDTO(this.name, this.id, this.version, this.createdDate, this.updateDate);
        }

        public String toString() {
            return "CustomerDTO.CustomerDTOBuilder(name=" + this.name + ", id=" + this.id + ", version=" + this.version + ", createdDate=" + this.createdDate + ", updateDate=" + this.updateDate + ")";
        }
    }
}