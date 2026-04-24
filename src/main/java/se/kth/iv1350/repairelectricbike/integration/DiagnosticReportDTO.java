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

    public String getDiagnosticResult() {
        return this.diagnosticResult;
    }

    public List<RepairTaskDTO> getRepairTasks() {
        return this.repairTasks;
    }

    public int getTotalCost() {
        return this.totalCost;
    }
}
