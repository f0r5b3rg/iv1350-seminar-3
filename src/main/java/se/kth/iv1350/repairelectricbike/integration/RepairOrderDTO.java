package se.kth.iv1350.repairelectricbike.integration;

/**
 * Contains information about a repair order.
 */

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class RepairOrderDTO {
    private final int id;
    private final CustomerDTO customer;
    private final BikeDTO bikeToRepair;
    private final String problemDescription;
    private final LocalDate estimatedCompletonDate;
    private final State state;
    private final DiagnosticReportDTO diagnosticReport;

    /**
     * Creates a new instance of a repair order.
     * 
     * @param id                      The repair order's id.
     * @param customer                The information of the customer's.
     * @param bikeToRepair            The information of the bike to repair.
     * @param estimatedCompletionDate The estimated completion date of the
     *                                reparation.
     * @param problemDescription      The customer's problem description of the
     *                                bike.
     * @param diagnosticReport        The technician's description of the bike's
     *                                current state.
     * @param repairTasks             The repair tasks needed for the bike.
     * @param totalCost               The total cost of the reparation.
     * @param state                   The current state of repair order.
     */

    public RepairOrderDTO(int id, CustomerDTO customer, BikeDTO bikeToRepair,
            String problemDescription, LocalDate estimatedCompletionDate,
            State state, DiagnosticReportDTO diagnosticReport) {
        this.id = id;
        this.customer = customer;
        this.bikeToRepair = bikeToRepair;
        this.problemDescription = problemDescription;
        this.estimatedCompletonDate = estimatedCompletionDate;
        this.state = state;
        this.diagnosticReport = diagnosticReport;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("id: " + id + ", ");
        builder.append("customer: " + customer + ", ");
        builder.append("bikeToRepair: " + bikeToRepair + ", ");
        builder.append("problemDescription: " + problemDescription + ", ");
        builder.append("estimatedCompletionDate: " + estimatedCompletonDate + ", ");
        builder.append("diagnosticResult: " + diagnosticReport.getDiagnosticResult() + ", ");
        builder.append("repairTasks: " + diagnosticReport.getRepairTasks() + ", ");
        builder.append("totalCost: " + diagnosticReport.getTotalCost() + ", ");
        builder.append("state: " + state);
        return builder.toString();
    }

    /**
     * Get the value of id
     * 
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Get the value of customer
     * 
     * @return the value of customer
     */
    public CustomerDTO getCustomer() {
        return customer;
    }

    /**
     * Get the value of the bike to repair
     * 
     * @return the value of the bike to repair
     */
    public BikeDTO getBikeToRepair() {
        return bikeToRepair;
    }

    /**
     * Get the value of date
     * 
     * @return the value of date as a LocalDate object
     */
    public LocalDate getDate() {
        return estimatedCompletonDate;
    }

    /**
     * Get the value of problem description
     * 
     * @return the value of problem description
     */
    public String getProblemDescription() {
        return problemDescription;
    }

    /**
     * Get the value of diagnostic report
     * 
     * @return the value of diagnostic report
     */
    public DiagnosticReportDTO getDiagnoticReport() {
        return diagnosticReport;
    }

    /**
     * Get the value of id
     * 
     * @return the value of id
     */
    public List<RepairTaskDTO> getRepairTasks() {
        return diagnosticReport.getRepairTasks();
    }

    /**
     * Get the value of total cost
     * 
     * @return the value of total cosr
     */
    public int getTotalCost() {
        return diagnosticReport.getTotalCost();
    }

    /**
     * Get the value of state
     * 
     * @return the value of state
     */
    public State getState() {
        return state;
    }

}
