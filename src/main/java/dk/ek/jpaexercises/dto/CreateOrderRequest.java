package dk.ek.jpaexercises.dto;

import java.time.LocalDate;

public record CreateOrderRequest(
        String orderNumber,
        LocalDate orderDate,
        Double totalAmount,
        Long customerId
) {}
