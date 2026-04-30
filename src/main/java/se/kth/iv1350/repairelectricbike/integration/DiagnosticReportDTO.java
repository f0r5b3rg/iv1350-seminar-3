package se.kth.iv1350.repairelectricbike.integration;

/**
 * Contains information about a diagnostic report.
 *
 */

import java.util.ArrayList;
import java.util.List;

public class DiagnosticReportDTO {
    private final String diagnosticResult;
    private final List<RepairTaskDTO> repairTasks;
    private final int totalCost;

    /**
     * Creates a new instance of a diagnostic report DTO.
     *
     * @param diagnosticResult Result of diagnosis.
     * @param repairTasks      Repair tasks as specified by technician.
     * @param totalCost        Total cost of all repair tasks.
     */
    public DiagnosticReportDTO(String diagnosticResult, List<RepairTaskDTO> repairTasks, int totalCost) {
        this.diagnosticResult = diagnosticResult;
        this.repairTasks = new ArrayList<RepairTaskDTO>();
        this.totalCost = totalCost;
    }

    public boolean equals(DiagnosticReportDTO toCompare) {
        return diagnosticResult.equals(toCompare.diagnosticResult) &&
                repairTasks.equals(toCompare.repairTasks) &&
                totalCost == toCompare.totalCost;
    }

    /**
     * Get the diagnostic result.
     * 
     * @return the diagnostic result.
     */
    public String getDiagnosticResult() {
        return this.diagnosticResult;
    }

    /**
     * Get the list of repair tasks.
     * 
     * @return the list of repair tasks.
     */
    public List<RepairTaskDTO> getRepairTasks() {
        return this.repairTasks;
    }

    /**
     * Get the total cost of all the repair tasks.
     * 
     * @return the total cost.
     */
    public int getTotalCost() {
        return this.totalCost;
    }
}
