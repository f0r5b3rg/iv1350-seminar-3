package se.kth.iv1350.repairelectricbike.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.repairelectricbike.integration.BikeDTO;
import se.kth.iv1350.repairelectricbike.integration.CustomerDTO;
import se.kth.iv1350.repairelectricbike.integration.CustomerRegistry;
import se.kth.iv1350.repairelectricbike.integration.RegistryCreator;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairelectricbike.integration.RepairTaskDTO;

public class RepairOrderTest {
    private RegistryCreator creator;
    private CustomerDTO customerDTO;
    private RepairOrder repairOrder;
    private List<BikeDTO> bikes;

    private RepairOrderRegistry repairOrderRegistry;

    @BeforeEach
    public void setUp() {
        creator = new RegistryCreator();
        bikes = new ArrayList<>(List.of(new BikeDTO("Disktrasa", "Yes", "123Drygt")));
        customerDTO = new CustomerDTO("Frödinge", "ost@kaka.se", "112", bikes);

        repairOrder = new RepairOrder(customerDTO, "123Drygt", "Bell is broken");

        CustomerRegistry customerRegistry = creator.getCustomerRegistry();
        repairOrderRegistry = creator.getRepairOrderRegistry();

        customerRegistry.addCustomer(customerDTO);
        repairOrderRegistry.addRepairOrder(repairOrder.convertToDTO());
    }

    @AfterEach
    public void tearDown() {
        creator = null;
        customerDTO = null;
        repairOrder = null;
        bikes = null;
        repairOrderRegistry = null;
    }

    @Test
    public void testConvertToDTO() {
        RepairOrderDTO repairOrderDTO = repairOrder.convertToDTO();

        assertEquals(repairOrder.getId(), repairOrderDTO.getId());
        assertEquals(repairOrder.getCustomer().getCustomerDTO(), repairOrderDTO.getCustomer());
        assertEquals(repairOrder.getBikeToRepair(), repairOrderDTO.getBikeToRepair());
        assertEquals(repairOrder.getProblemDescription(), repairOrderDTO.getProblemDescription());
        assertEquals(repairOrder.getEstimatedCompletionDate(), repairOrderDTO.getEstimatedCompletionDate());
        assertEquals(repairOrder.getState(), repairOrderDTO.getState());
    }

    @Test
    void testAddRepairTask() {
        String repairTaskProblemDesc = "Bike doesn't exist";
        int costToRepair = 6767;
        RepairTaskDTO newRepairTask = new RepairTaskDTO(repairTaskProblemDesc, costToRepair);
        repairOrder.addRepairTask(repairTaskProblemDesc, costToRepair);
        
        boolean result = newRepairTask.equals(repairOrder.getDiagnosticReport().getRepairTasks().getFirst());
        assertTrue(result);
    }
}
