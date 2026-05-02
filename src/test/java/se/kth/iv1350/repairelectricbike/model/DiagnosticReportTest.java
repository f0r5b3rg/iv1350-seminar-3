package se.kth.iv1350.repairelectricbike.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.repairelectricbike.integration.DiagnosticReportDTO;
import se.kth.iv1350.repairelectricbike.integration.RepairTaskDTO;

public class DiagnosticReportTest {
    private DiagnosticReport diagnosticReport;   
    @BeforeEach
    public void StartUp() {
        diagnosticReport = new DiagnosticReport();
    }

    @Test
    void testConvertToDTO() {
        DiagnosticReportDTO result = diagnosticReport.ConvertToDTO();

        assertEquals(diagnosticReport.getDiagnosticResult(), result.getDiagnosticResult());
        assertEquals(diagnosticReport.getRepairTasks(), result.getRepairTasks());
        assertEquals(diagnosticReport.getTotalCost(), result.getTotalCost());

    }

    @Test
    void testAddRepairTask() {
        RepairTaskDTO repairTask1 = new RepairTaskDTO("Bike is too big", 1);
        diagnosticReport.addRepairTask(repairTask1);

        boolean result = diagnosticReport.getRepairTasks().getFirst().equals(repairTask1);
        assertTrue(result);
    }
}
