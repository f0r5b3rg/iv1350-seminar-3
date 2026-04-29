package main.test.integration;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.repairelectricbike.integration.*;

public class RepairOrderRegistryTest {
    private RegistryCreator creator;
    private CustomerDTO customer;
    private RepairOrderDTO repairOrder; 
    private List<BikeDTO> bikes;

    @Before
    public void setUp() {
        creator = new RegistryCreator();
        bikes = new ArrayList<BikeDTO>( List.of(new BikeDTO("Disktrasa", "Yes", "123Drygt")));
        customer = new CustomerDTO("Frödinge", "ost@kaka.se", "112", bikes);
        repairOrder = new RepairOrderDTO(0, customer, bikes.get(0), "Bell is broken", LocalDate.now(), State.NEWLY_CREATED, null);

        creator.getCustomerRegistry().addCustomer(customer);
        creator.getRepairOrderRegistry().addRepairOrder(repairOrder);
    }

    
    @Test
    public void testAddRepairOrder() {
        RepairOrderDTO newRepairOrder = new RepairOrderDTO(1, customer, bikes.get(0), "Bell is broken again", LocalDate.now(), State.NEWLY_CREATED, null);
        creator.getRepairOrderRegistry().addRepairOrder(newRepairOrder);
        List<RepairOrderDTO> repairOrders = creator.getRepairOrderRegistry().findRepairOrders(State.NEWLY_CREATED);
        
        assertEquals(2, repairOrders.size());
    }

    @Test
    public void testFindRepairOrders() {
        List<RepairOrderDTO> repairOrders = creator.getRepairOrderRegistry().findRepairOrders(State.NEWLY_CREATED);

        assertEquals(1, repairOrders.size());
        assertEquals(State.NEWLY_CREATED, repairOrders.get(0).getState());
    }

    // EEEEH 8 = 1?!?!?!?!?!?!?!?!
    @Test
    public void testGetRepairOrderCount() {
        int count = RepairOrderRegistry.getRepairOrderCount();

        assertEquals(1, count);        
    }

    @Test
    public void testGetRepairOrderDTObyID() {
        RepairOrderDTO result = creator.getRepairOrderRegistry().getRepairOrderDTObyID(0);

        Objects.equals(repairOrder, result);
    }

    @Test
    public void testUpdateCompletionDate() {
        LocalDate newDate = LocalDate.of(2026, 04, 29);
        creator.getRepairOrderRegistry().updateCompletionDate(0, newDate);

        assertEquals(newDate, creator.getRepairOrderRegistry().getRepairOrderDTObyID(0).getDate());

    }

    @Test
    public void testUpdateDiagnosticReport() {
        

    }

    @Test
    public void testUpdateState() {
        State newState = State.ACCEPTED;

        creator.getRepairOrderRegistry().updateState(0, newState);

        assertEquals(newState, creator.getRepairOrderRegistry().getRepairOrderDTObyID(0).getState());

    }
}
