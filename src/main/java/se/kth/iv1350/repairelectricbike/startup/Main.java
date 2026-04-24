package se.kth.iv1350.repairelectricbike.startup;

/**
 * Contains the <code>main</code> method. Performs all startup of the
 * application.
 */

import se.kth.iv1350.repairelectricbike.integration.RegistryCreator;
import se.kth.iv1350.repairelectricbike.integration.Printer;
import se.kth.iv1350.repairelectricbike.controller.Controller;
import se.kth.iv1350.repairelectricbike.view.View;

public class Main {
    /**
     * Starts the application.
     *
     * @param args The application does not take any command line parameters.
     */

    public static void main(String[] args) {
        RegistryCreator creator = new RegistryCreator();
        Printer printer = new Printer();
        Controller contr = new Controller(creator, printer);
        new View(contr).sampleExecution();
    }
}
