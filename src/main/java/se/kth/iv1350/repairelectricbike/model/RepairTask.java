package se.kth.iv1350.repairelectricbike.model;

/**
 * Contains all data for one repair task.
 *
 */

public class RepairTask {
    private String repairTaskDescription;
    private int costToRepair;

    RepairTask(String repairTaskDescription, int costToRepair) {
        this.repairTaskDescription = repairTaskDescription;
        this.costToRepair = costToRepair;
    }
}
