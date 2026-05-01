package se.kth.iv1350.repairelectricbike.integration;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains information about a diagnostic report.
 */
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
        this.repairTasks = (repairTasks != null) ? new ArrayList<>(repairTasks): new ArrayList<>();
        this.totalCost = totalCost;
    }

    public boolean equals(DiagnosticReportDTO toCompare) {
        return diagnosticResult.equals(toCompare.diagnosticResult) &&
                repairTasks.equals(toCompare.repairTasks) &&
                totalCost == toCompare.totalCost;
    }

    @Override
    public String toString() {
        return String.format(
            """
                Diagnostic Result: %s
                Repair Tasks: %s
                Total cost: %d
            """,
            diagnosticResult,
            repairTasks,
            totalCost
        );
    }

    /**
     * Get the value of diagnostic result.
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
     * Get the value of the total cost of all repair tasks.
     * 
     * @return the total cost of all repair tasks.
     */
    public int getTotalCost() {
        return this.totalCost;
    }
}
