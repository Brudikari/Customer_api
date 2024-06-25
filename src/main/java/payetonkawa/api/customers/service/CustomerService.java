package payetonkawa.api.customers.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payetonkawa.api.customers.model.Customer;
import payetonkawa.api.customers.repository.CustomerRepository;

import java.util.Optional;

@Data
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> findCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
    }

}
