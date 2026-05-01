package se.kth.iv1350.repairelectricbike.model;

import se.kth.iv1350.repairelectricbike.integration.DiagnosticReportDTO;
import se.kth.iv1350.repairelectricbike.integration.RepairTaskDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains diagnostic report information concerning a repair order.
 */
public class DiagnosticReport {
    private String diagnosticResult;
    private List<RepairTaskDTO> repairTasks;
    private int totalCost;

    DiagnosticReport() {
        this.diagnosticResult = "";
        this.repairTasks = new ArrayList<>();
        this.totalCost = 0;
    }

    void addRepairTask(RepairTaskDTO repairTask) {
        repairTasks.add(repairTask);
        totalCost += repairTask.getCostToRepair();
    }

    DiagnosticReportDTO ConvertToDTO() {
        return new DiagnosticReportDTO(this.diagnosticResult, this.repairTasks, this.totalCost);
    }

    /**
     * Get the diagnostic result.
     *
     * @return the diagnostic result.
     */
    public String getDiagnosticResult() {
        return diagnosticResult;
    }

    /**
     * Get the list of repair tasks.
     *
     * @return the list of repair tasks.
     */
    public List<RepairTaskDTO> getRepairTasks() {
        return repairTasks;
    }


    /**
     * Get the total cost of all the repair tasks.
     *
     * @return the total cost.
     */
    public int getTotalCost() {
        return totalCost;
    }

}