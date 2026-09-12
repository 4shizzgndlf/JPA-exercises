package dk.ek.jpaexercises.dto;

import java.util.List;

public record CustomerDTO(
        Long id,
        String name,
        String email,
        String phone,
        List<OrderSummaryDTO> orders
) {}