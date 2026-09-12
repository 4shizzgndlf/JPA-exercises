package dk.ek.jpaexercises.service;

import dk.ek.jpaexercises.dto.OrderDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderDTO> getAllOrders();
    Optional<OrderDTO> getOrderById(Long id);
    OrderDTO createOrder(String orderNumber, LocalDate orderDate, Double totalAmount, Long customerId);
}