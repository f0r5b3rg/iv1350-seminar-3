package se.kth.iv1350.repairelectricbike.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.repairelectricbike.integration.CustomerDTO;
import se.kth.iv1350.repairelectricbike.integration.CustomerRegistry;
import se.kth.iv1350.repairelectricbike.integration.DiagnosticReportDTO;
import se.kth.iv1350.repairelectricbike.integration.Printer;
import se.kth.iv1350.repairelectricbike.integration.RegistryCreator;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairelectricbike.integration.State;
import se.kth.iv1350.repairelectricbike.model.RepairOrder;

/**
 * This is the application's only controller class. All calls to the model pass
 * through here.
 */
public class Controller {
    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;
    private Printer printer;

    // Keeps track of the repair order actively being handled.
    private RepairOrder activeRepairOrder;

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
     * Searches for an existing customer in the customerRegistry.
     *
     * @param phoneNumber The phone number of the sought customer.
     */
    public CustomerDTO searchCustomer(String phoneNumber) {
        return customerRegistry.searchCustomer(phoneNumber);
    }

    /**
     * Returns an int value which represents the customers repair order id.
     *
     * @param phoneNumber  The phone number of the customer.
     * @param problemDesc  The description of the problems with the customers bike.
     * @param bikeSerialNo The serial number of the customers bike.
     */
    public void createRepairOrder(String phoneNumber, String bikeSerialNo, String problemDesc) {
        CustomerDTO customer = searchCustomer(phoneNumber);
        activeRepairOrder = new RepairOrder(customer, problemDesc, bikeSerialNo);
    }

    public void saveActiveRepairOrder() {
        RepairOrderDTO toSave = activeRepairOrder.convertToDTO();
        repairOrderRegistry.addRepairOrder(toSave);
    }

    public void saveCustomer(CustomerDTO customer) {
        customerRegistry.addCustomer(customer);
    }

    /**
     * Returns a List of each repair order that is in the sought state.
     *
     * @param state The state of the repair orders.
     */
    public List<RepairOrderDTO> findRepairOrders(State state) {
        return repairOrderRegistry.findRepairOrders(state);
    }

    /**
     * hmmmm
     *
     * @param repairOrderId         The id of the repair order.
     * @param repairTaskDescription ...
     * @param costToRepair          ...
     */
    public void addRepairTask(int repairOrderId, String repairTaskDescription, int costToRepair) {
        //coming soon
    }

    /**
     * Updates the current state of the repair order.
     *
     * @param repairOrderId The id of the repair order.
     * @param newState      The new state of the repair order.
     */
    public void updateState(int repairOrderId, State newState) {
        repairOrderRegistry.updateState(repairOrderId, newState);
    }

    /**
     * Updates the diagnostic report of the repair order.
     *
     * @param repairOrderID    The id of the repair order.
     * @param diagnosticReport ...
     */
    public void updateDiagnosticReport(int repairOrderID, String diagnosticResult) {
        repairOrderRegistry.updateDiagnosticReport(repairOrderID, diagnosticResult);
    }

    /**
     * Finds the repair order and prints it.
     *
     * @param repairOrderId The id of the repair order.
     */
    public void printRepairOrder(int repairOrderId) {
        RepairOrderDTO repairOrderToPrint = repairOrderRegistry.getRepairOrderDTObyID(repairOrderId);
        printer.printRepairOrder(repairOrderToPrint); //metoden är inte implementerad
    }

    /**
     * Updates the estimated completion date of the repair order.
     *
     * @param repairOrderId The id of the repair order.
     * @param estimatedDate The new estimated completion date of the repair order.
     */
    public void updateCompletionDate(int repairOrderId, LocalDate estimatedDate) {
        repairOrderRegistry.updateCompletionDate(repairOrderId, estimatedDate);
    }
}
