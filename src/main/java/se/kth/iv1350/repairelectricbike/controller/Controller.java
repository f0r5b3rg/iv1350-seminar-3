package se.kth.iv1350.repairelectricbike.controller;

import se.kth.iv1350.repairelectricbike.integration.RegistryCreator;
import se.kth.iv1350.repairelectricbike.integration.CustomerRegistry;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairelectricbike.integration.Printer;

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
}
