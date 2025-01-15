package ir.ambaqinejad.springmvcrestservices.service;

import ir.ambaqinejad.springmvcrestservices.mapper.CustomerMapper;
import ir.ambaqinejad.springmvcrestservices.model.CustomerDTO;
import ir.ambaqinejad.springmvcrestservices.repository.CustomerRepository;
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
public class CustomerServiceJPAImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID uuid) {
        return Optional.
                ofNullable(
                        customerMapper.customerToCustomerDTO(customerRepository.findById(uuid)
                                .orElse(null)));
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomerById(UUID customerId) {

    }

    @Override
    public void patchCustomerById(UUID customerId, CustomerDTO customerDTO) {

    }
}
