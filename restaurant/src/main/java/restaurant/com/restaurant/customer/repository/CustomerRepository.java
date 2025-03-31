package restaurant.com.restaurant.customer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import restaurant.com.restaurant.customer.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
