package dk.ek.jpaexercises.mapper;

import dk.ek.jpaexercises.dto.OrderDTO;
import dk.ek.jpaexercises.model.Order;

public class OrderMapper {

    public static OrderDTO toDTO(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getOrderNumber(),
                order.getOrderDate(),
                order.getTotalAmount(),
                CustomerMapper.toSummaryDTO(order.getCustomer())
        );
    }
}