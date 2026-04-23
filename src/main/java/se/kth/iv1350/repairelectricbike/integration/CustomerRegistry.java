package se.kth.iv1350.repairelectricbike.integration;

/** 
 * Contains all calls to the data store with registered customers.
 * Currently simulates database retrieval by storing customers instead.
 */

import java.util.ArrayList;
import java.util.List;

public class CustomerRegistry {
    private List<CustomerData> customers = new ArrayList<>();

    CustomerRegistry() {
        addCustomer();
    }

    private void addCustomer() {
        customers.add(new CustomerData("Test Testsson", "test@test.com", 0707777777, new ArrayList<>(List.of(
                new BikeDTO("Scott", "Tester", "123test67"),
                new BikeDTO("Lamborghini", "Aventador", "123bike123")))));
        customers.add(new CustomerData("Prov Provsdotter", "prov@prov.se", 1231231212, new ArrayList<>(List.of(
                new BikeDTO("Artemis", "Two", "321liftoff")))));
    }

    /**
     * Search for a customer with the matching phone number.
     *
     * @param searchedPhoneNumber The phone number that is searched for.
     *
     * @return A customer with the matching phone number if found, else
     *         <code>null</code>.
     */
    public CustomerDTO findCustomer(int searchedPhoneNumber) {
        for (CustomerData customer : customers) {
            if (hasPhoneNumber(searchedPhoneNumber, customer)) {
                return new CustomerDTO(customer.name, customer.email, customer.phoneNumber, customer.ownedBikes);
            }
        }
        return null;
    }

    private boolean hasPhoneNumber(int phoneNumber, CustomerData customer) {
        if (phoneNumber == customer.phoneNumber) {
            return true;
        }
        return false;
    }

    private class CustomerData {
        private String name;
        private String email;
        private int phoneNumber;
        private List<BikeDTO> ownedBikes;

        public CustomerData(String name, String email, int phoneNumber, List<BikeDTO> ownedBikes) {
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.ownedBikes = ownedBikes;
        }
    }
}
