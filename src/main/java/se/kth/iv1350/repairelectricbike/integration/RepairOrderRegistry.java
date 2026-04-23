package se.kth.iv1350.repairelectricbike.integration;

/**
 * Contains all calls to the data store with all repair orders.
 * Currently simulates database retrieval by storing repair orders instead.
 */

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import se.kth.iv1350.repairelectricbike.model.State;

public class RepairOrderRegistry {
    private List<RepairOrderData> repairOrders = new ArrayList<>();

    RepairOrderRegistry() {
        addRepairOrder();
    }

    private void addRepairOrder() {

    }

    private class RepairOrderData {
        private int id;
        private CustomerDTO customer;
        private BikeDTO bikeToRepair;
        private LocalDate estimatedCompletonDate;
        private String problemDescription;
        private String diagnosticReport;
        private List<RepairTaskDTO> repairTasks;
        private int totalCost;
        private State state;

        public RepairOrderData(int id, CustomerDTO customer, BikeDTO bikeToRepair, LocalDate estimatedCompletionDate,
                String problemDescription, String diagnosticReport, List<RepairTaskDTO> repairTasks, int totalCost,
                State state) {
            this.id = id;
            this.customer = customer;
            this.bikeToRepair = bikeToRepair;
            this.estimatedCompletonDate = estimatedCompletionDate;
            this.problemDescription = problemDescription;
            this.diagnosticReport = diagnosticReport;
            this.repairTasks = repairTasks;
            this.totalCost = totalCost;
            this.state = state;
        }
    }
}
