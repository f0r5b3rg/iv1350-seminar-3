package se.kth.iv1350.repairelectricbike.integration;

/**
 * This class is responsible for instantiating all registries.
 */
public class RegistryCreator {
    private CustomerRegistry customerRegistry = new CustomerRegistry();
    private RepairOrderRegistry repairOrderRegistry = new RepairOrderRegistry();

    public CustomerRegistry getCustomerRegistry() {
        return customerRegistry;
    }

    public RepairOrderRegistry getRepairOrderRegistry() {
        return repairOrderRegistry;
    }
}
