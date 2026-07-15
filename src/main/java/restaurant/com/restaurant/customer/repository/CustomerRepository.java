package restaurant.com.restaurant.customer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import restaurant.com.restaurant.customer.model.Customer;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
    Optional<Customer> findByUserId(UUID userId);
}
