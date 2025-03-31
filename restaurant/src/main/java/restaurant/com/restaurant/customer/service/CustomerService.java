package restaurant.com.restaurant.customer.service;

import org.springframework.stereotype.Service;
import restaurant.com.restaurant.customer.model.Customer;
import restaurant.com.restaurant.customer.repository.CustomerRepository;
import restaurant.com.restaurant.user.model.User;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(User user) {

        Customer customer = new Customer();
        customer.setUser(user);

        customerRepository.save(customer);
    }
}