package se.kth.iv1350.repairelectricbike.integration;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerRegistryTest {
    private RegistryCreator creator;
    private CustomerDTO customer;
    private List<BikeDTO> bikes;

    private CustomerRegistry customerRegistry;

    @Before
    public void setUp() {
        creator = new RegistryCreator();
        bikes = new ArrayList<>(List.of(new BikeDTO("Disktrasa", "Yes", "123Drygt")));
        customer = new CustomerDTO("Frödinge", "ost@kaka.se", "112", bikes);
        customerRegistry = creator.getCustomerRegistry();

        customerRegistry.addCustomer(customer);
    }

    @After
    public void tearDown()
    {
        creator = null;
        customer = null;
        bikes = null;
        customerRegistry = null;
    }

    @Test
    public void testAddCustomer() {
        customerRegistry.addCustomer(customer);

        boolean result = customer.equals(customerRegistry.searchCustomer(customer.getPhoneNumber()));
        assertTrue(result);
    }

    @Test
    public void testSearchCustomer() {
        boolean result = customer.equals(customerRegistry.searchCustomer(customer.getPhoneNumber()));
        assertTrue(result);
    }
}
