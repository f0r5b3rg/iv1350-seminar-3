package se.kth.iv1350.repairelectricbike.integration;

/**
 * Contains information about a repair task.
 */

public class RepairTaskDTO {
    private final String repairTaskDescription;
    private final int costToRepair;

    /**
     * Creates a new instance of a repair task.
     * 
     * @param repairTaskDescription The description of a repair task.
     * @param costToRepair          The cost for a repair task.
     */
    public RepairTaskDTO(String repairTaskDescription, int costToRepair) {
        this.repairTaskDescription = repairTaskDescription;
        this.costToRepair = costToRepair;
    }

    @Override
    public String toString() {
        return "repairTaskDescription: " + repairTaskDescription + ", " +
                "costToRepair: " + costToRepair;
    }

    public boolean equals(RepairTaskDTO toCompare) {
       return repairTaskDescription.equals(toCompare.repairTaskDescription) &&
       costToRepair == toCompare.costToRepair;
    }

    /**
     * Get the value of repair task description
     * 
     * @return the value of repair task description
     */
    public String getRepairTaskDescription() {
        return repairTaskDescription;
    }

    /**
     * Get the value of cost to repair.
     * 
     * @return the value of cost to repair.
     */
    public int getCostToRepair() {
        return costToRepair;
    }
}
