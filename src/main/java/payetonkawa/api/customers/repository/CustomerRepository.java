package payetonkawa.api.customers.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import payetonkawa.api.customers.model.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.id =: id")
    Optional<Customer> findById(Integer id);
}
