package test.java.se.kth.iv1350.repairelectricbike.integration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.repairelectricbike.integration.CustomerDTO;
import se.kth.iv1350.repairelectricbike.integration.RegistryCreator;
import se.kth.iv1350.repairelectricbike.integration.BikeDTO;

public class CustomerRegistryTest {
    private RegistryCreator creator;
    private CustomerDTO customer;
    private List<BikeDTO> bikes;

    @Before
    public void setUp() {
        creator = new RegistryCreator();
        bikes = new ArrayList<BikeDTO>( List.of(new BikeDTO("Disktrasa", "Yes", "123Drygt")));
        customer = new CustomerDTO("Frödinge", "ost@kaka.se", "112", bikes);
        
    }

    @Test
    public void testAddCustomer() {
        creator.getCustomerRegistry().addCustomer(customer);
        CustomerDTO result = creator.getCustomerRegistry().searchCustomer(customer.getPhoneNumber());

        Objects.equals(customer, result);
    }

    @Test
    public void testSearchCustomer() {
        CustomerDTO result = creator.getCustomerRegistry().searchCustomer(customer.getPhoneNumber());

        Objects.equals(customer, result);
    }
}
