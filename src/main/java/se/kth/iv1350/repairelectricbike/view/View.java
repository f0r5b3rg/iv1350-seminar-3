package se.kth.iv1350.repairelectricbike.view;

import se.kth.iv1350.repairelectricbike.controller.Controller;

/**
 * This program has no view, instead, this class is a placeholder for the entire
 * view.
 */
public class View {
    private Controller controller;

    /**
     * Creates a new instance.
     *
     * @param controller The controller that is used for all operations.
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Simulates a user input that generates calls to all system operations.
     */
    public void sampleExecution() {
        System.out.println("Executed");
    }

}
