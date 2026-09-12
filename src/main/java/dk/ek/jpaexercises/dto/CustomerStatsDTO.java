package dk.ek.jpaexercises.dto;

public record CustomerStatsDTO(
        Long id,
        String name,
        int totalOrders,
        Double totalSpent
) {}
