package main.test.controller;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.repairelectricbike.controller.*;
import se.kth.iv1350.repairelectricbike.model.*;
import se.kth.iv1350.repairelectricbike.integration.*;

public class ControllerTest {

    private RegistryCreator creator;
    private Controller controller;
    private List<BikeDTO> bikes;
    private CustomerDTO customer;
    private RepairOrderDTO repairOrder;


    /**
     * Setups the registries and controller, 
     * creates one customer and repair order and saves it in the respectively registry.
     */
    @Before
    public void setUp() {
        creator = new RegistryCreator();
        controller = new Controller(creator, new Printer());
        
        BikeDTO testBike1 = new BikeDTO("SixSeven", "GenAlpha", "67WC69");
        BikeDTO testBike2 = new BikeDTO("SixNine", "GenBeta", "0");
        bikes = new ArrayList<>(List.of(testBike1, testBike2));
        customer = new CustomerDTO("Douglas Andersson", "Doggelito1337@gmail.com", "07676767", bikes);
        creator.getCustomerRegistry().addCustomer(customer);

        repairOrder = new RepairOrderDTO(0, customer, bikes.get(0), "Hjulet är böjt :(", LocalDate.now(), State.NEWLY_CREATED, null);
        creator.getRepairOrderRegistry().addRepairOrder(repairOrder);


    }

    @Test
    public void testAddRepairTask() {

    }

    @Test
    public void testCreateRepairOrder() {

    }

    @Test
    public void testFindRepairOrders() {
        List<RepairOrderDTO> repairOrders = controller.findRepairOrders(State.NEWLY_CREATED);



    }

    @Test
    public void testPrintRepairOrder() {

    }

    @Test
    public void testSaveActiveRepairOrder() {

    }

    @Test
    public void testSearchCustomer() {
        CustomerDTO result = controller.searchCustomer("07676767");

        Objects.equals(customer, result); 
    }

    @Test
    public void testSaveAndSearchCustomer() {
        List<BikeDTO> bikes = new ArrayList<BikeDTO>(List.of(new BikeDTO("Dalahäst", "Hofors2000", "123gäng456")));
        CustomerDTO customerToSave = new CustomerDTO("Linus Sandin", "sandalen67@hotmail.com", "07696969", bikes);

        controller.saveCustomer(customerToSave);

        CustomerDTO result = controller.searchCustomer("07696969");

        Objects.equals(customerToSave, result);
    }

    @Test
    public void testUpdateCompletionDate() {
        LocalDate newDate = LocalDate.of(2026, 04, 29);

        controller.updateCompletionDate(0, newDate);

        assertEquals(newDate, repairOrder.getDate());
    }

    @Test
    public void testUpdateDiagnosticReport() {

    }

    @Test
    public void testUpdateState() {
        State newState = State.ACCEPTED;
        RepairOrderDTO repairOrderToUpdate = creator.getRepairOrderRegistry().getRepairOrderDTObyID(0);
        controller.updateState(repairOrderToUpdate.getId(), newState);

        assertEquals(State.ACCEPTED, repairOrderToUpdate.getState());
    }
}
