package payetonkawa.api.customers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import payetonkawa.api.customers.model.Customer;
import payetonkawa.api.customers.repository.CustomerRepository;
import payetonkawa.api.customers.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindCustomerById() {

        Integer customerId = 1;
        Customer mockCustomer = new Customer();
        mockCustomer.setId(customerId);
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(mockCustomer));

        Optional<Customer> result = customerService.findCustomerById(customerId);

        assertEquals(mockCustomer.getId(), result.get().getId());
        verify(customerRepository, times(1)).findById(customerId);
    }

    @Test
    public void testGetAllCustomers() {

        Iterable<Customer> mockCustomers = generateMockCustomers(5);
        when(customerRepository.findAll()).thenReturn(mockCustomers);

        Iterable<Customer> result = customerService.getAllCustomers();

        assertEquals(5, result.spliterator().getExactSizeIfKnown());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    public void testSaveCustomer() {

        Customer customerToSave = new Customer();
        customerToSave.setId(1);
        when(customerRepository.save(any(Customer.class))).thenReturn(customerToSave);

        Customer savedCustomer = customerService.saveCustomer(customerToSave);

        assertEquals(customerToSave.getId(), savedCustomer.getId());
        verify(customerRepository, times(1)).save(customerToSave);
    }

    @Test
    public void testDeleteCustomerById() {

        Integer customerId = 1;
        doNothing().when(customerRepository).deleteById(customerId);

        customerService.deleteCustomerById(customerId);

        verify(customerRepository, times(1)).deleteById(customerId);
    }

    // generate mock customers for testing
    private Iterable<Customer> generateMockCustomers(int count) {
        List<Customer> customers = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            Customer customer = new Customer();
            customer.setId(i);
            customer.setFirstName("FirstName" + i);
            customer.setLastName("LastName" + i);
            customer.setMail("email" + i + "@example.com");
            customer.setAddress("Address " + i);
            customer.setCompany("Company " + i);
            customers.add(customer);
        }
        return customers;
    }
}
