package se.kth.iv1350.repairelectricbike.model;

/**
 * Contains information about a repair task.
 *
 */

import java.time.LocalDate;
import se.kth.iv1350.repairelectricbike.integration.CustomerDTO;
import se.kth.iv1350.repairelectricbike.integration.BikeDTO;

public class RepairOrder {
    private int id;
    private Customer customer;
    private BikeDTO bikeToRepair;
    private String problemDescription;
    private LocalDate estimatedCompletionDate;
    private State state;
    private DiagnosticReport diagnosticReport;

    public RepairOrder(CustomerDTO customerDTO, String bikeSerialNo, String problemDescription) {
        this.id = 0; // RANDOM
        this.customer = new Customer(customerDTO);
        this.bikeToRepair = this.customer.getBikeFromSerialNo(bikeSerialNo);
        this.problemDescription = problemDescription;
        this.estimatedCompletionDate = LocalDate.now();
        this.state = State.NEWLY_CREATED;
        this.diagnosticReport = new DiagnosticReport();
    }
}
