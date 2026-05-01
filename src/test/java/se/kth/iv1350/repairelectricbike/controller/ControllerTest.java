package se.kth.iv1350.repairelectricbike.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.repairelectricbike.integration.*;

public class ControllerTest {

    private RegistryCreator creator;
    private RepairOrderRegistry repairOrderRegistry;
    private Controller controller;
    private List<BikeDTO> bikes;
    private CustomerDTO customer;
    private RepairOrderDTO repairOrder;
    private DiagnosticReportDTO diagnosticReport;


    //Setups the registries and controller, 
    // creates one customer and repair order and saves it in the respective registry.
    @Before
    public void setUp() {
        creator = new RegistryCreator();
        controller = new Controller(creator, new Printer());
        repairOrderRegistry = creator.getRepairOrderRegistry();
        
        BikeDTO testBike1 = new BikeDTO("SixSeven", "GenAlpha", "67WC69");
        BikeDTO testBike2 = new BikeDTO("SixNine", "GenBeta", "0");
        bikes = new ArrayList<>(List.of(testBike1, testBike2));
        customer = new CustomerDTO("Douglas Andersson", "Doggelito1337@gmail.com", "07676767", bikes);
        creator.getCustomerRegistry().addCustomer(customer);

        diagnosticReport = new DiagnosticReportDTO(null, null, 0);
        repairOrder = new RepairOrderDTO(0, customer, bikes.getFirst(), "Hjulet är böjt :(", LocalDate.now(), State.NEWLY_CREATED, diagnosticReport);
        repairOrderRegistry.addRepairOrder(repairOrder);
    }

    @After
    public void tearDown()
    {
        creator = null;
        controller = null;
        bikes = null;
        customer = null;
        repairOrder = null;
        diagnosticReport = null;

    }

    @Test
    public void testSearchCustomer() {
        CustomerDTO result = controller.searchCustomer("07676767");
        assertTrue(customer.equals(result));
    }

    @Test
    public void testCreateAndSaveActiveRepairOrder() {
        String problemDesc = "För lite öl på styret";
        controller.createRepairOrder(customer.getPhoneNumber(), bikes.get(1).getSerialNo(), problemDesc);
        controller.saveActiveRepairOrder();

        List<RepairOrderDTO> repairOrders = controller.findRepairOrders(State.NEWLY_CREATED);
        RepairOrderDTO result = repairOrders.getLast();
        
        assertEquals(customer.getPhoneNumber(), result.getCustomer().getPhoneNumber());
        assertEquals(problemDesc, result.getProblemDescription());
        assertEquals(bikes.get(1).getSerialNo(), result.getBikeToRepair().getSerialNo());
        assertEquals(State.NEWLY_CREATED, result.getState());
    }

    @Test
    public void testSaveCustomer() {
        List<BikeDTO> bikes = new ArrayList<>(List.of(new BikeDTO("Dalahäst", "Hofors2000", "123gäng456")));
        CustomerDTO customerToSave = new CustomerDTO("Linus Sandin", "sandalen67@hotmail.com", "07696969", bikes);

        controller.saveCustomer(customerToSave);
        CustomerDTO result = controller.searchCustomer("07696969");

        assertTrue(customerToSave.equals(result));
    }

    @Test
    public void testFindRepairOrders() {
        List<RepairOrderDTO> repairOrders = controller.findRepairOrders(State.NEWLY_CREATED);

        assertEquals(1, repairOrders.size());

        for(RepairOrderDTO order : repairOrders)
            assertEquals(State.NEWLY_CREATED, order.getState());
    }

    @Test
    public void testAddRepairTask() {
        String repairTaskProbDesc = "Problem löst";
        int costToRepair = 6767;

        controller.createRepairOrder(customer.getPhoneNumber() ,bikes.get(1).getSerialNo(), "Problem");
        controller.addRepairTask(repairTaskProbDesc, costToRepair);
        controller.saveActiveRepairOrder();

        int newId = RepairOrderRegistry.getRepairOrderCount() - 1;

        DiagnosticReportDTO result = repairOrderRegistry.getRepairOrderDTObyID(newId).getDiagnosticReport();

        assertEquals(repairTaskProbDesc, result.getRepairTasks().getFirst().getRepairTaskDescription());
        assertEquals(costToRepair, result.getRepairTasks().getFirst().getCostToRepair());
    }

    @Test
    public void testUpdateState() {
        State newState = State.ACCEPTED;

        controller.updateState(0, newState);

        assertEquals(State.ACCEPTED, repairOrderRegistry.getRepairOrderDTObyID(0).getState());
    }

    @Test
    public void testUpdateDiagnosticResult() {
        repairOrderRegistry.updateDiagnosticResult(0, "Lol");

        assertEquals("Lol", repairOrderRegistry.getRepairOrderDTObyID(0).getDiagnosticReport().getDiagnosticResult());
    }


    @Test
    public void testUpdateCompletionDate() {
        LocalDate newDate = LocalDate.of(2026, 04, 29);
        controller.updateCompletionDate(0, newDate);

        assertEquals(newDate, repairOrderRegistry.getRepairOrderDTObyID(0).getDate());
    }
}
