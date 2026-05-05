package ch.samt.customers.data;

import ch.samt.customers.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //@Query("SELECT * FROM customer WHERE LOWER(surname) = LOWER(:surname)")
    List<Customer> findBySurnameIgnoreCase(String surname);

    //@Query("SELECT * FROM customer WHERE city = ?")
    List<Customer> findByAddressCityIgnoreCase(String city);

    Optional<Customer> findById(Long id);
    //List<Customer> findByAgeUnder(String agelimit);
}
