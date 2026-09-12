package dk.ek.jpaexercises.service;

import dk.ek.jpaexercises.dto.OrderDTO;
import dk.ek.jpaexercises.mapper.OrderMapper;
import dk.ek.jpaexercises.model.Customer;
import dk.ek.jpaexercises.model.Order;
import dk.ek.jpaexercises.repository.CustomerRepository;
import dk.ek.jpaexercises.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOs = new ArrayList<>();
        for (Order order : orders) {
            orderDTOs.add(OrderMapper.toDTO(order));
        }
        return orderDTOs;
    }

    @Override
    public Optional<OrderDTO> getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return Optional.of(OrderMapper.toDTO(order.get()));
        }
        return Optional.empty();
    }

    @Override
    public OrderDTO createOrder(String orderNumber, LocalDate orderDate, Double totalAmount, Long customerId) {
        // Find the customer
        Customer customer = customerRepository.findById(customerId) .orElseThrow(() -> new RuntimeException( "Customer not found with id: " + customerId ) );
        // Create the order
        Order order = new Order( orderNumber, orderDate, totalAmount, customer );
        // Save the order
        Order savedOrder = orderRepository.save(order);
        // Convert Order entity to OrderDTO
        return OrderMapper.toDTO(savedOrder); }
    }