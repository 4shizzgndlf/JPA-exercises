package dk.ek.jpaexercises.dto;

public record CustomerSummaryDTO(
        Long id,
        String name,
        String email
) {}