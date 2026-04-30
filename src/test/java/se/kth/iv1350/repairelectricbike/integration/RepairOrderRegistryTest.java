package se.kth.iv1350.repairelectricbike.integration;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.repairelectricbike.model.RepairOrder;

public class RepairOrderRegistryTest {
    private RegistryCreator creator;
    private CustomerDTO customer;
    private RepairOrderDTO repairOrder; 
    private List<BikeDTO> bikes;

    private RepairOrderRegistry repairOrderRegistry;

    @Before
    public void setUp() {
        creator = new RegistryCreator();
        bikes = new ArrayList<BikeDTO>( List.of(new BikeDTO("Disktrasa", "Yes", "123Drygt")));
        customer = new CustomerDTO("Frödinge", "ost@kaka.se", "112", bikes);
        repairOrder = new RepairOrder(customer, "123Drygt", "Bell is broken").convertToDTO();

        CustomerRegistry customerRegistry = creator.getCustomerRegistry();
        repairOrderRegistry = creator.getRepairOrderRegistry();

        customerRegistry.addCustomer(customer);
        repairOrderRegistry.addRepairOrder(repairOrder);
    }
    
    @Test
    public void testAddRepairOrder() {
        RepairOrderDTO newRepairOrder = new RepairOrder(customer, "123Drygt", "Bell is broken again").convertToDTO();
        repairOrderRegistry.addRepairOrder(newRepairOrder);
        List<RepairOrderDTO> repairOrders = repairOrderRegistry.findRepairOrders(State.NEWLY_CREATED);
        
        assertEquals(2, repairOrders.size());
        boolean result = repairOrder.equals(repairOrders.get(0));
        assertTrue(result );
    }

    @Test
    public void testFindRepairOrders() {
        List<RepairOrderDTO> repairOrders = repairOrderRegistry.findRepairOrders(State.NEWLY_CREATED);

        assertEquals(1, repairOrders.size());
        assertEquals(State.NEWLY_CREATED, repairOrders.getFirst().getState());
    }

    // EEEEH 8 = 1?!?!?!?!?!?!?!?!
    @Test
    public void testGetRepairOrderCount() {
        int count = RepairOrderRegistry.getRepairOrderCount();

        assertEquals(1, count);        
    }

    @Test
    public void testGetRepairOrderDTObyID() {
        boolean result = repairOrder.equals(repairOrderRegistry.getRepairOrderDTObyID(0));
        assertTrue(result);
    }

    @Test
    public void testUpdateCompletionDate() {
        LocalDate newDate = LocalDate.of(2026, 04, 29);
        repairOrderRegistry.updateCompletionDate(0, newDate);

        assertEquals(newDate, repairOrderRegistry.getRepairOrderDTObyID(0).getDate());
    }

    @Test
    public void testUpdateDiagnosticResult() {
        String newDiagnosticResult = "Problem solved";
        repairOrderRegistry.updateDiagnosticResult(0, newDiagnosticResult);
        assertEquals(newDiagnosticResult, repairOrderRegistry.getRepairOrderDTObyID(0).getDiagnosticReport().getDiagnosticResult());
    }

    @Test
    public void testUpdateState() {
        State newState = State.ACCEPTED;

        repairOrderRegistry.updateState(0, newState);

        assertEquals(newState, repairOrderRegistry.getRepairOrderDTObyID(0).getState());

    }
}
