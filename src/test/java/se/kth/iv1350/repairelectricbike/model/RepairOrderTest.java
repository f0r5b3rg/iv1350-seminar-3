package se.kth.iv1350.repairelectricbike.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.repairelectricbike.integration.*;

import java.util.ArrayList;
import java.util.List;

public class RepairOrderTest {

    private RegistryCreator creator;
    private CustomerDTO customerDTO;
    private Customer customer;
    private RepairOrder repairOrder;
    private List<BikeDTO> bikes;

    private RepairOrderRegistry repairOrderRegistry;

    @Before
    public void setUp() {
        creator = new RegistryCreator();
        bikes = new ArrayList<BikeDTO>( List.of(new BikeDTO("Disktrasa", "Yes", "123Drygt")));
        customerDTO = new CustomerDTO("Frödinge", "ost@kaka.se", "112", bikes);
        customer = new Customer(customerDTO);

        repairOrder = new RepairOrder(customerDTO, "123Drygt", "Bell is broken");

        CustomerRegistry customerRegistry = creator.getCustomerRegistry();
        repairOrderRegistry = creator.getRepairOrderRegistry();

        customerRegistry.addCustomer(customerDTO);
        repairOrderRegistry.addRepairOrder(repairOrder.convertToDTO());
    }

    @After
    public void tearDown()
    {
        creator = null;
        customerDTO = null;
        customer = null;
        repairOrder = null;
        bikes = null;
        repairOrderRegistry = null;
    }

    @Test
    public void testConvertToDTO() {

    }

    @Test
    public void testAddRepairTask() {
        String repairTaskProblemDesc = "Bike doesn't exist";
        int costToRepair = 6767;
        RepairTaskDTO newRepairTask = new RepairTaskDTO(repairTaskProblemDesc, costToRepair);
        repairOrder.addRepairTask(repairTaskProblemDesc, costToRepair);
        boolean result = newRepairTask.equals(repairOrder.getDiagnosticReport().getRepairTasks().get(0));
        assertTrue(result);
    }
}
