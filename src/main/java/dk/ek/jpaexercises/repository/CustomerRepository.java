package dk.ek.jpaexercises.repository;

import dk.ek.jpaexercises.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // JpaRepository provides CRUD methods out of the box:
    // - save()
    // - findById()
    // - findAll()
    // - deleteById()
    // - count()
    // and many more!
}