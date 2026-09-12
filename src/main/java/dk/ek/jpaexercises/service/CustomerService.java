package dk.ek.jpaexercises.service;

import dk.ek.jpaexercises.dto.CustomerDTO;
import dk.ek.jpaexercises.dto.CustomerStatsDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    Optional<CustomerDTO> getCustomerById(Long id);
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerStatsDTO getCustomerStats(Long id);
}