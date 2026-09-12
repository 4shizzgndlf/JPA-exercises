package dk.ek.jpaexercises.mapper;

import dk.ek.jpaexercises.dto.CustomerDTO;
import dk.ek.jpaexercises.dto.CustomerSummaryDTO;
import dk.ek.jpaexercises.dto.OrderSummaryDTO;
import dk.ek.jpaexercises.model.Customer;
import dk.ek.jpaexercises.model.Order;

import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customer customer) {
        List<OrderSummaryDTO> orderSummaries = new ArrayList<>();
        for (Order order : customer.getOrders()) {
            orderSummaries.add(toOrderSummaryDTO(order));
        }

        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                orderSummaries
        );
    }

    public static CustomerSummaryDTO toSummaryDTO(Customer customer) {
        return new CustomerSummaryDTO(
                customer.getId(),
                customer.getName(),
                customer.getEmail()
        );
    }

    private static OrderSummaryDTO toOrderSummaryDTO(Order order) {
        return new OrderSummaryDTO(
                order.getId(),
                order.getOrderNumber(),
                order.getOrderDate(),
                order.getTotalAmount()
        );
    }
}