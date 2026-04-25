package se.kth.iv1350.repairelectricbike.model;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.repairelectricbike.integration.RepairTaskDTO;

/**
 * Contains diagnostic report information concerning a repair order
 *
 */
public class DiagnosticReport {
    private String diagnosticResult;
    private List<RepairTaskDTO> repairTasks;
    private int totalCost;

    DiagnosticReport() {
        this.diagnosticResult = "";
        this.repairTasks = new ArrayList<RepairTaskDTO>();
        this.totalCost = 0;
    }

    void addRepairTask(RepairTaskDTO repairTask) {
        repairTasks.add(repairTask);
    }

    public String getDiagnosticResult() {
        return diagnosticResult;
    }

    public List<RepairTaskDTO> getRepairTasks() {
        return repairTasks;
    }

    public int getTotalCost() {
        return totalCost;
    }

}
