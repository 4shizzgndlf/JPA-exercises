package dk.ek.jpaexercises.dto;

import java.time.LocalDate;

public record OrderDTO(
        Long id,
        String orderNumber,
        LocalDate orderDate,
        Double totalAmount,
        CustomerSummaryDTO customer
) {}