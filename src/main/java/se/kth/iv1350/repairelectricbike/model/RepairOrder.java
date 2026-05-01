package se.kth.iv1350.repairelectricbike.model;

import se.kth.iv1350.repairelectricbike.integration.*;

import java.time.LocalDate;

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
        this.id = RepairOrderRegistry.getRepairOrderCount();
        this.customer = new Customer(customerDTO);
        this.bikeToRepair = this.customer.getBikeFromSerialNo(bikeSerialNo);
        this.problemDescription = problemDescription;
        this.estimatedCompletionDate = LocalDate.now();
        this.state = State.NEWLY_CREATED;
        this.diagnosticReport = new DiagnosticReport();
    }

    public RepairOrderDTO convertToDTO() {
        return new RepairOrderDTO(this.id, this.customer.getCustomerDTO(), this.bikeToRepair, this.problemDescription, this.estimatedCompletionDate, this.state, this.diagnosticReport.ConvertToDTO());
    }

    public void addRepairTask(String repairTaskDescription, int costToRepair) {
        RepairTaskDTO taskToAdd = new RepairTaskDTO(repairTaskDescription, costToRepair);
        diagnosticReport.addRepairTask(taskToAdd);
    }

    /**
     * Get the repair order's id.
     * 
     * @return the value of id.
     */
    public int getId() {
        return id;
    }

    /**
     * Get the value of customer.
     * 
     * @return the value of customer.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Get the value of the bike to repair. 
     * 
     * @return the value of the bike to repair 
     */
    public BikeDTO getBikeToRepair() {
        return bikeToRepair;
    }

    /**
     * Get the value of the problem description.
     * 
     * @return the value of the problem description
     */
    public String getProblemDescription() {
        return problemDescription;
    }

    /**
     * Get the value of the estimated completion date. 
     * 
     * @return the value of the estimated completion date. 
     */
    public LocalDate getEstimatedCompletionDate() {
        return estimatedCompletionDate;
    }

    /**
     * Get the value of the state. 
     * 
     * @return the value of the state.
     */
    public State getState() {
        return state;
    }

    /**
     * Get the value of the diagnostic report.
     * 
     * @return the value of the diagnostic report. 
     */
    public DiagnosticReport getDiagnosticReport() {
        return diagnosticReport;
    }

}
