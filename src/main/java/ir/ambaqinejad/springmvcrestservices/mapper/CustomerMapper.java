package ir.ambaqinejad.springmvcrestservices.mapper;

import ir.ambaqinejad.springmvcrestservices.entity.Customer;
import ir.ambaqinejad.springmvcrestservices.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDTOToCustomer(CustomerDTO customerDTO);
    CustomerDTO customerToCustomerDTO(Customer customer);
}
