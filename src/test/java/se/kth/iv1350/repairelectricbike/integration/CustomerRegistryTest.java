package se.kth.iv1350.repairelectricbike.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerRegistryTest {
    private RegistryCreator creator;
    private CustomerRegistry customerRegistry;
    private CustomerDTO customer;
    private List<BikeDTO> bikes;

    @BeforeEach
    public void SetUp() {
        creator = new RegistryCreator();
        bikes = new ArrayList<>(List.of(new BikeDTO("Disktrasa", "Yes", "123Drygt")));
        customer = new CustomerDTO("Frödinge", "ost@kaka.se", "112", bikes);
        customerRegistry = creator.getCustomerRegistry();
        customerRegistry.addCustomer(customer);
    }

    @AfterEach
    public void tearDown() {
        creator = null;
        customer = null;
        bikes = null;
        customerRegistry = null;
    }

    @Test
    void testAddCustomer() {
        customerRegistry.addCustomer(customer);

        boolean result = customer.equals(customerRegistry.searchCustomer(customer.getPhoneNumber()));
        assertTrue(result);
    }

    @Test
    void testSearchCustomer() {
        boolean result = customer.equals(customerRegistry.searchCustomer(customer.getPhoneNumber()));
        
        assertTrue(result);
    }
}
