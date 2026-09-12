package dk.ek.jpaexercises.config;

import dk.ek.jpaexercises.model.Customer;
import dk.ek.jpaexercises.model.Order;
import dk.ek.jpaexercises.repository.CustomerRepository;
import dk.ek.jpaexercises.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public InitData(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
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

        //Add 5 orders
        Order order1 = new Order("896", LocalDate.now(), 99.00, customer1);
        Order order2 = new Order("576", LocalDate.now(), 299.00, customer2);
        Order order3 = new Order("234", LocalDate.now(), 49.00, customer3);
        Order order4 = new Order("522", LocalDate.now(), 199.00, customer2);
        Order order5 = new Order("967", LocalDate.now(), 499.00, customer1);

        // Use the helper method to maintain BOTH sides
        customer1.addOrder(order1);
        customer2.addOrder(order2);
        customer3.addOrder(order3);
        customer2.addOrder(order4);
        customer1.addOrder(order5);

        // Save orders
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        orderRepository.save(order4);
        orderRepository.save(order5);

        System.out.println("Initial data created:");
        System.out.println("- Customers: " + customerRepository.count());
        System.out.println("- Orders: " + orderRepository.count());
    }
}