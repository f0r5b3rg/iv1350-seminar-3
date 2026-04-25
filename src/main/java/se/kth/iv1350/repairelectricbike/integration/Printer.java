package se.kth.iv1350.repairelectricbike.integration;

/**
 * Printer interface used for all printouts
 */
public class Printer {
    /**
     * Prints the specified repair order.
     * Dummy implementation prints to <code>System.out</code>.
     *
     * @param repairOrderToPrint   Contains the repair order data to be printed.
     */
    public void printRepairOrder(RepairOrderDTO repairOrderToPrint) {
        System.out.println(repairOrderToPrint);
    }
}
