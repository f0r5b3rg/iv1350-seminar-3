package se.kth.iv1350.repairelectricbike.model;

/**
 * Contains diagnostic report information concerning a repair order
 *
 */

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.repairelectricbike.integration.RepairTaskDTO;

class DiagnosticReport {
    private String diagnosticResult;
    private List<RepairTaskDTO> repairTasks;
    private int totalCost;

    DiagnosticReport() {
        this.diagnosticResult = "";
        this.repairTasks = new ArrayList<RepairTaskDTO>();
        this.totalCost = totalCost;
    }

    void addRepairTask(RepairTaskDTO repairTask) {
        repairTasks.add(repairTask);
    }
}
