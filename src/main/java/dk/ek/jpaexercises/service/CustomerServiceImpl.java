package dk.ek.jpaexercises.service;

import dk.ek.jpaexercises.dto.CustomerDTO;
import dk.ek.jpaexercises.dto.CustomerStatsDTO;
import dk.ek.jpaexercises.mapper.CustomerMapper;
import dk.ek.jpaexercises.model.Customer;
import dk.ek.jpaexercises.model.Order;
import dk.ek.jpaexercises.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOs = new ArrayList<>();
        for (Customer customer : customers) {
            customerDTOs.add(CustomerMapper.toDTO(customer));
        }
        return customerDTOs;
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return Optional.of(CustomerMapper.toDTO(customer.get()));
        }
        return Optional.empty();
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.name(),
                customerDTO.email(),
                customerDTO.phone()
        );
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.toDTO(savedCustomer);
    }

    @Override
    public CustomerStatsDTO getCustomerStats(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        int totalOrders = customer.getOrders().size();
        double totalSpent = 0.0;
        for (Order order : customer.getOrders()) {
            totalSpent += order.getTotalAmount();
        }
        return new CustomerStatsDTO(customer.getId(), customer.getName(), totalOrders, totalSpent);
    }
}