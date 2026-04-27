package se.kth.iv1350.repairelectricbike.integration;

/**
 * Contains all calls to the data store with all repair orders.
 * Currently simulates database retrieval by storing repair orders instead.
 */

import se.kth.iv1350.repairelectricbike.model.RepairOrder;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class RepairOrderRegistry {
    private List<RepairOrderData> repairOrders;

    RepairOrderRegistry() {
        this.repairOrders = new ArrayList<>();
    }

    public void addRepairOrder(RepairOrderDTO repairOrderDTO) {
        repairOrders.add(new RepairOrderData(repairOrderDTO.getId(), repairOrderDTO.getCustomer(),
                repairOrderDTO.getBikeToRepair(),
                repairOrderDTO.getProblemDescription(), repairOrderDTO.getDate(), repairOrderDTO.getState(),
                repairOrderDTO.getDiagnoticReport()));
    }

    public List<RepairOrderDTO> findRepairOrders(State state) {
        List<RepairOrderDTO> result = new ArrayList<>();
        for (RepairOrderData repairOrder : repairOrders) {
            if (state == repairOrder.state) {
                result.add(new RepairOrderDTO(repairOrder.id, repairOrder.customer, repairOrder.bikeToRepair,
                        repairOrder.problemDescription, repairOrder.estimatedCompletionDate, repairOrder.state,
                        repairOrder.diagnosticReport));
            }
        }
        return result;
    }



    public RepairOrderDTO getRepairOrderDTObyID(int repairOrderId)
    {
        for (RepairOrderData repairOrder : repairOrders)
        {
            if (repairOrder.id == repairOrderId)
                return new RepairOrderDTO(repairOrder.id, repairOrder.customer, repairOrder.bikeToRepair,
                        repairOrder.problemDescription, repairOrder.estimatedCompletionDate, repairOrder.state,
                        repairOrder.diagnosticReport);
        }
        return null;
    }

    public void updateState(int repairOrderID, State newState) {
        RepairOrderData repairOrder = repairOrders.get(repairOrderID);
        if (repairOrder != null)
            repairOrder.state = newState;
    }

    public void updateDiagnosticReport(int repairOrderID, String diagnosticReport) {
        RepairOrderData repairOrder = repairOrders.get(repairOrderID);

        if (repairOrder != null)
        {
            List<RepairTaskDTO> repairTasks = repairOrder.diagnosticReport.getRepairTasks();
            int totalCost = repairOrder.diagnosticReport.getTotalCost();
            repairOrder.diagnosticReport = new DiagnosticReportDTO(diagnosticReport, repairTasks, totalCost);
        }
    }

    private RepairOrderData getRepairOrderById(int repairOrderId)
    {
        for (RepairOrderData repairOrder : repairOrders)
        {
            return repairOrder;
        }
        return null;
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
