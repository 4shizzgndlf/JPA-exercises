package dk.ek.jpaexercises.repository;

import dk.ek.jpaexercises.model.Customer;
import dk.ek.jpaexercises.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Find all orders for a specific customer
    List<Order> findByCustomer(Customer customer);

    // Find all orders for a customer by customer ID
    List<Order> findByCustomerId(Long customerId);

    // Find orders by order number
    Order findByOrderNumber(String orderNumber);
}