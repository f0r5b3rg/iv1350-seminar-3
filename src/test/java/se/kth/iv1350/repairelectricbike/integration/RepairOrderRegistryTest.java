package se.kth.iv1350.repairelectricbike.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.repairelectricbike.model.RepairOrder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepairOrderRegistryTest {
    private RegistryCreator creator;
    private RepairOrderRegistry repairOrderRegistry;
    private CustomerDTO customer;
    private RepairOrderDTO repairOrder; 
    private List<BikeDTO> bikes;

    @BeforeEach
    public void SetUp() {
        RepairOrderRegistry.setRepairOrderCount(0);
        creator = new RegistryCreator();
        bikes = new ArrayList<>(List.of(new BikeDTO("Disktrasa", "Yes", "123Drygt")));
        customer = new CustomerDTO("Frödinge", "ost@kaka.se", "112", bikes);
        repairOrder = new RepairOrder(customer, "123Drygt", "Bell is broken").convertToDTO();

        CustomerRegistry customerRegistry = creator.getCustomerRegistry();
        repairOrderRegistry = creator.getRepairOrderRegistry();

        customerRegistry.addCustomer(customer);
        repairOrderRegistry.addRepairOrder(repairOrder);
    }

    @AfterEach
    public void tearDown() {
        RepairOrderRegistry.setRepairOrderCount(0);
        creator = null;
        customer = null;
        repairOrder = null;
        bikes = null;
        repairOrderRegistry =  null;
    }

    @Test
    void testAddRepairOrder() {
        RepairOrderDTO newRepairOrder = new RepairOrder(customer, "123Drygt", "Bell is broken again").convertToDTO();
        repairOrderRegistry.addRepairOrder(newRepairOrder);
        List<RepairOrderDTO> repairOrders = repairOrderRegistry.findRepairOrders(State.NEWLY_CREATED);
        
        assertEquals(2, repairOrders.size());
        boolean result = repairOrder.equals(repairOrders.getFirst());
        assertTrue(result);
    }

    @Test
    void testFindRepairOrders() {
        List<RepairOrderDTO> repairOrders = repairOrderRegistry.findRepairOrders(State.NEWLY_CREATED);

        assertEquals(1, repairOrders.size());
        assertEquals(State.NEWLY_CREATED, repairOrders.getFirst().getState());
    }

    @Test
    void testGetRepairOrderCount() {
        int count = RepairOrderRegistry.getRepairOrderCount();

        assertEquals(1, count);     
    }

    @Test
    void testGetRepairOrderDTObyID() {
        boolean result = repairOrder.equals(repairOrderRegistry.getRepairOrderDTObyID(0));

        assertTrue(result);
    }

    @Test
    void testUpdateCompletionDate() {
        LocalDate newDate = LocalDate.of(2026, 04, 29);
        int id = repairOrder.getId();
        repairOrderRegistry.updateCompletionDate(id, newDate);

        assertEquals(newDate, repairOrderRegistry.getRepairOrderDTObyID(id).getDate());
    }

    @Test
    void testUpdateDiagnosticResult() {
        String newDiagnosticResult = "Problem solved";
        repairOrderRegistry.updateDiagnosticResult(0, newDiagnosticResult);

        assertEquals(newDiagnosticResult, repairOrderRegistry.getRepairOrderDTObyID(0).getDiagnosticReport().getDiagnosticResult());
    }

    @Test
    void testUpdateState() {
        State newState = State.ACCEPTED;
        repairOrderRegistry.updateState(0, newState);

        assertEquals(newState, repairOrderRegistry.getRepairOrderDTObyID(0).getState());
    }
}
