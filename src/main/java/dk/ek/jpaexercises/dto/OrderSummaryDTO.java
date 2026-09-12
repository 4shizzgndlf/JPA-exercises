package dk.ek.jpaexercises.dto;

import java.time.LocalDate;

public record OrderSummaryDTO(
        Long id,
        String orderNumber,
        LocalDate orderDate,
        Double totalAmount
) {}