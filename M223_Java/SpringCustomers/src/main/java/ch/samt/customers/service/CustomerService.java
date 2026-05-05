package ch.samt.customers.service;

import ch.samt.customers.data.CustomerRepository;
import ch.samt.customers.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void saver(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> findBySurnameIgnoreCase(String surname) {
        return customerRepository.findBySurnameIgnoreCase(surname);
    }

    public List<Customer> findByCityIgnoreCase(String city) {
        return customerRepository.findByAddressCityIgnoreCase(city);
    }

    public Customer findById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }
}
