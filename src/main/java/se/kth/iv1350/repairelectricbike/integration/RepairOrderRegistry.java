package se.kth.iv1350.repairelectricbike.integration;

/**
 * Contains all calls to the data store with all repair orders.
 * Currently simulates database retrieval by storing repair orders instead.
 */

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

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
        private String problemDescription;
        private LocalDate estimatedCompletionDate;
        private State state;
        private DiagnosticReportDTO diagnosticReport;

        public RepairOrderData(int id, CustomerDTO customer, BikeDTO bikeToRepair, 
                String problemDescription, LocalDate estimatedCompletionDate, 
                State state, DiagnosticReportDTO diagnosticReport) {
            this.id = id;
            this.customer = customer;
            this.bikeToRepair = bikeToRepair;
            this.problemDescription = problemDescription;
            this.estimatedCompletionDate = estimatedCompletionDate;
            this.state = state;
            this.diagnosticReport = diagnosticReport;
        }
    }
}
