package se.kth.iv1350.repairelectricbike.model;

import java.time.LocalDate;

import se.kth.iv1350.repairelectricbike.integration.*;

/**
 * Contains information about a repair task.
 *
 */
public class RepairOrder {
    private int id;
    private Customer customer;
    private BikeDTO bikeToRepair;
    private String problemDescription;
    private LocalDate estimatedCompletionDate;
    private State state;
    private DiagnosticReport diagnosticReport;

    public RepairOrder(CustomerDTO customerDTO, String bikeSerialNo, String problemDescription) {
        this.id = 0; // Implement ID generation.
        this.customer = new Customer(customerDTO);
        this.bikeToRepair = this.customer.getBikeFromSerialNo(bikeSerialNo);
        this.problemDescription = problemDescription;
        this.estimatedCompletionDate = LocalDate.now();
        this.state = State.NEWLY_CREATED;
        this.diagnosticReport = new DiagnosticReport();
    }

    public RepairOrderDTO convertToDTO() {
        return new RepairOrderDTO(this.id, this.customer.getCustomerDTO(), this.bikeToRepair, this.problemDescription, this.estimatedCompletionDate, this.state, convertToDTO(this.diagnosticReport));
    }

    private DiagnosticReportDTO convertToDTO(DiagnosticReport diagnosticReportDTO) {
        return new DiagnosticReportDTO(diagnosticReportDTO.getDiagnosticResult(), diagnosticReportDTO.getRepairTasks(), diagnosticReportDTO.getTotalCost());
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public BikeDTO getBikeToRepair() {
        return bikeToRepair;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public LocalDate getEstimatedCompletionDate() {
        return estimatedCompletionDate;
    }

    public State getState() {
        return state;
    }

    public DiagnosticReport getDiagnosticReport() {
        return diagnosticReport;
    }

}
