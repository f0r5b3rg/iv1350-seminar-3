package se.kth.iv1350.repairelectricbike.model;

/**
 * Contains diagnostic report information concerning a repair order
 *
 */

import java.util.ArrayList;
import java.util.List;

class DiagnosticReport {
    private String diagnosticResult;
    private List<RepairTask> repairTasks;
    private int totalCost;

    DiagnosticReport() {
        this.diagnosticResult = "";
        this.repairTasks = new ArrayList<RepairTask>();
        this.totalCost = totalCost;
    }

    void addRepairTask(RepairTask repairTask) {
        repairTasks.add(repairTask);
    }
}
