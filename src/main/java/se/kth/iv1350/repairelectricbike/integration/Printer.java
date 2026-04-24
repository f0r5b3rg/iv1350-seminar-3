package se.kth.iv1350.repairelectricbike.integration;

/**
 * Printer interface used for all printouts
 */
public class Printer {
    /**
     * Prints the specified repair order.
     * Dummy implementation prints to <code>System.out</code>.
     *
     * @param RepairOrderDTO
     */
    public void printRepairOrder(RepairOrderDTO repairOrderToPrint) {
        System.out.println(repairOrderToPrint);
    }
}
