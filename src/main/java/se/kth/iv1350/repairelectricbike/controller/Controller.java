package se.kth.iv1350.repairelectricbike.controller;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.repairelectricbike.integration.*;
import se.kth.iv1350.repairelectricbike.model.State;
import java.time.LocalDate;

/**
 * This is the application's only controller class. All calls to the model pass
 * through here.
 */
public class Controller {
    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;
    private Printer printer;


    /**
     * Creates a new instance.
     *
     * @param regCreator Used to get all classes that handle database calls.
     * @param printer    Interface to printer.
     */
    public Controller(RegistryCreator regCreator, Printer printer) {
        this.customerRegistry = regCreator.getCustomerRegistry();
        this.repairOrderRegistry = regCreator.getRepairOrderRegistry();
        this.printer = printer;
    }


    /**
     * Searches for an existing customer in the customRegistry.
     *
     * @param phoneNumber The phone number of the sought customer.
     */
    public CustomerDTO searchCustomer(int phoneNumber)
    {
        return customerRegistry.findCustomer(phoneNumber);
    }


    /**
     * Returns a List of each repair order that is in the sought state
     *
     * @param state The state of the repair orders.
     */
    public List<RepairOrderDTO> findRepairOrders(State state)
    {
        //return repairOrderRegistry.findRepairOrders(state);
        return null; //väntar på implementation
    }


    /**
     * Returns an int value which represents the customers repair order id.
     *
     * @param phoneNumber The phone number of the customer.
     * @param problemDesc The description of the problems with the customers bike.
     * @param bikeSerialNo The serial number of the customers bike.
     */
    public int createRepairOrder(int phoneNumber, String problemDesc, int bikeSerialNo)
    {
        //return repairOrderRegistry.createRepairOrder(int phoneNumber, String problemDesc, int bikeSerialNo)
        return 0; //väntar på implementation
    }


    /**
     * hmmmm
     *
     * @param repairOrderId The id of the repair order.
     * @param repairTaskDescription ...
     * @param costOfRepair ...
     */
    public void addRepairTask(int repairOrderId, String repairTaskDescription, int costOfRepair)
    {
        //Coming soon
    }


    /**
     * hmmmm
     *
     * @param repairOrderId The id of the repair order.
     * @param newState ...
     */
    public void updateState(int repairOrderId, State newState)
    {
        //Coming soon
    }


    /**
     * Updates the diagnostic report of the repair order.
     *
     * @param repairOrderID The id of the repair order.
     * @param diagnosticReport ...
     */
    public void updateDiagnosticReport(int repairOrderID, String diagnosticReport )
    {
        //repairOrderRegistry.updateDiagnosticReport(repairOrderID, diagnosticReport);
        //väntar på implementation
    }


    /**
     * hmmmm
     *
     * @param repairOrderId The id of the repair order.
     */
    public void printRepairOrder(int repairOrderId)
    {
        //Coming soon
    }


    /**
     * Updates the estimated completion date of the repair order.
     *
     * @param repairOrderId The id of the repair order.
     * @param estimatedDate The new estimated completion date of the repair order.
     */
    public void updateCompletionDate(int repairOrderId, LocalDate estimatedDate)
    {
        //repairOrderRegistry.updateCompletionDate(repairOrderId, estimatedDate);
        //väntar på implementation
    }

}
