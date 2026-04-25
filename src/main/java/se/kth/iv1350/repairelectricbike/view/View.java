package se.kth.iv1350.repairelectricbike.view;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.repairelectricbike.controller.Controller;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.integration.State;
import se.kth.iv1350.repairelectricbike.integration.BikeDTO;
import se.kth.iv1350.repairelectricbike.integration.CustomerDTO;

/**
 * This program has no view, instead, this class is a placeholder for the entire
 * view.
 */
public class View {
    private final Controller controller;

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
        System.out.println("Sample execution started");
        // Creates test customers to use for sample execution.
        // The test customers are created and then passed to CustomerRegistry to be saved.

        // Customer 1 bike setup
        BikeDTO customer1Bike1 = new BikeDTO("Golfklubba", "Iron 7", "dragonslayer67");
        BikeDTO customer1Bike2 = new BikeDTO("Toastskagen", "ShrimpPLate", "231lobster1");
        List<BikeDTO> customer1Bikes = new ArrayList<>(List.of(customer1Bike1, customer1Bike2));
        // Customer 2 bike setup.
        BikeDTO customer2Bike1 = new BikeDTO("TrigonometriV2", "EulerE", "SinCosTan1");
        List<BikeDTO> customer2Bikes = new ArrayList<>(List.of(customer2Bike1));
        // Customer 3 bike setup.
        BikeDTO customer3Bike1 = new BikeDTO("Truck", "leksaksbil", "291uudnsd");
        List<BikeDTO> customer3Bikes = new ArrayList<>(List.of(customer3Bike1));
        // Customer 4 bike setup.
        BikeDTO customer4Bike1 = new BikeDTO("Scott", "Tester", "123test67");
        BikeDTO customer4Bike2 = new BikeDTO("Lamborghini", "Aventador", "123bike123");
        List<BikeDTO> customer4Bikes = new ArrayList<>(List.of(customer4Bike1, customer4Bike2));
        // Customer 5 bike setup.
        BikeDTO customer5Bike1 = new BikeDTO("Artemis", "Two", "321liftoff");
        List<BikeDTO> customer5Bikes = new ArrayList<>(List.of(customer5Bike1));

        // Create all test customers.
        CustomerDTO customer1 = new CustomerDTO("Pia", "pi314@gmail.com", "070676767", customer1Bikes);
        CustomerDTO customer2 = new CustomerDTO("Shaun Bannanpannkaka", "banan@djungel.com", "0702137", customer2Bikes);
        CustomerDTO customer3 = new CustomerDTO("Lasses Gunnar", "Lasso@hotmail.com", "3049343", customer3Bikes);
        CustomerDTO customer4 = new CustomerDTO("Test Testsson", "test@test.com", "0707777777", customer4Bikes);
        CustomerDTO customer5 = new CustomerDTO("Prov Provsdotter", "prov@prov.se", "1231231212", customer5Bikes);

        // Save test customers and corresponding new repair order to registries.
        ArrayList<CustomerDTO> testCustomers = new ArrayList<>(List.of(customer1, customer2, customer3, customer4, customer5));
        for (CustomerDTO customer : testCustomers) {
            // Adds customer to CustomerRegistry.
            controller.saveCustomer(customer);
            // Creates a repair order and sets it as active repair order.
            controller.createRepairOrder(customer.getPhoneNumber(), "Bike inverted", customer.getOwnedBikes().getFirst().getSerialNo());
            // Saves active repair order.
            controller.saveActiveRepairOrder();
        }

        // At this point the customer registry and repair order registry contains 5 test objects.

        // Finds all newly created repair orders and add to list.
        List<RepairOrderDTO> foundRepairOrders = controller.findRepairOrders(State.NEWLY_CREATED);
    }
}
