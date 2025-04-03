package restaurant.com.restaurant.customer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import restaurant.com.restaurant.customer.model.Customer;
import restaurant.com.restaurant.customer.repository.CustomerRepository;
import restaurant.com.restaurant.user.model.User;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceUTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void givenUser_whenCreateCustomer_thenCreateCustomer() {
        UUID id = UUID.randomUUID();
        User user = new User();
        user.setId(id);
        Customer customer = new Customer();
        customer.setUser(user);

        customerService.createCustomer(user);

        verify(customerRepository, times(1)).save(any());
    }

    @Test
    public void givenExistingUserId_whenGetCustomerByUserId_thenReturnUser(){
        User user = new User();
        user.setId(UUID.randomUUID());

        Customer expectedCustomer = new Customer();
        expectedCustomer.setUser(user);

        when(customerRepository.findByUserId(user.getId())).thenReturn(Optional.of(expectedCustomer));

        Customer actualCustomer = customerService.getCustomerByUserId(user.getId());

        assertEquals(expectedCustomer.getUser().getId(), actualCustomer.getUser().getId());
        verify(customerRepository, times(1)).findByUserId(user.getId());
    }
}