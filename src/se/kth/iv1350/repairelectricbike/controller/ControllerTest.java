package se.kth.iv1350.repairelectricbike.controller;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.repairelectricbike.controller.*;
import se.kth.iv1350.repairelectricbike.model.*;
import se.kth.iv1350.repairelectricbike.integration.*;

public class ControllerTest {

    private List<BikeDTO> getTestBikes() {
        BikeDTO testBike1 = new BikeDTO("SixSeven", "GenAlpha", "67WC69");
        BikeDTO testBike2 = new BikeDTO("SixNine", "GenBeta", "Tung67Sahur");
        return new ArrayList<>(List.of(testBike1, testBike2));
    }
    private CustomerDTO gettestCustomer() {
        return new CustomerDTO("Douglas Andersson", "doggelito1337@gmail.com", "07676767", getTestBikes());
    }
    
    @Test
    public void testAddRepairTask() {

    }

    @Test
    public void testCreateRepairOrder() {

    }

    @Test
    public void testFindRepairOrders() {

    }

    @Test
    public void testPrintRepairOrder() {

    }

    @Test
    public void testSaveActiveRepairOrder() {

    }

    @Test
    public void testSaveCustomer() {

    }

    @Test
    public void testSearchCustomer() {
        RegistryCreator creator = new RegistryCreator();
        Controller controller = new Controller(creator, new Printer());

        CustomerDTO customer = gettestCustomer();

        creator.getCustomerRegistry().addCustomer(customer);

        CustomerDTO result = controller.searchCustomer("07676767");
        assertEquals(customer, result);
        assertEquals(customer.getName(), result.getName());
        assertEquals(customer.getEmail(), result.getEmail());
        assertEquals(customer.getPhoneNumber(), result.getPhoneNumber());
        assertEquals(customer.getOwnedBikes(), result.getOwnedBikes());
    }

    @Test
    public void testUpdateCompletionDate() {

    }

    @Test
    public void testUpdateDiagnosticReport() {

    }

    @Test
    public void testUpdateState() {

    }
}
