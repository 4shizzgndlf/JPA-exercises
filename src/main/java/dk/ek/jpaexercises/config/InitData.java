package dk.ek.jpaexercises.config;

import dk.ek.jpaexercises.model.Customer;
import dk.ek.jpaexercises.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public InitData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save customers
        Customer customer1 = new Customer("John Doe", "john@example.com", "12345678");
        Customer customer2 = new Customer("Jane Smith", "jane@example.com", "23456789");
        Customer customer3 = new Customer("Bob Johnson", "bob@example.com", "34567890");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        System.out.println("Initial data created: " + customerRepository.count() + " customers");
    }
}