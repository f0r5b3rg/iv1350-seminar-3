package se.kth.iv1350.repairelectricbike.integration;

/** 
 * Contains all calls to the data store with registered customers.
 * Currently simulates database retrieval by storing customers instead.
 */

import java.util.ArrayList;
import java.util.List;

public class CustomerRegistry {
    private List<CustomerData> customers;

    CustomerRegistry() {
        this.customers = new ArrayList<CustomerData>();
    }

    public void addCustomer(ArrayList<CustomerDTO> customers) {
        for (CustomerDTO customerDTO : customers) {
            this.customers
                    .add(new CustomerData(customerDTO.getName(), customerDTO.getEmail(), customerDTO.getPhoneNumber(),
                            customerDTO.getOwnedBikes()));
        }
    }

    /**
     * Search for a customer with the matching phone number.
     *
     * @param searchedPhoneNumber The phone number that is searched for.
     *
     * @return A customer with the matching phone number if found, else
     *         <code>null</code>.
     */
    public CustomerDTO searchCustomer(int searchedPhoneNumber) {
        for (CustomerData customer : customers) {
            if (hasPhoneNumber(searchedPhoneNumber, customer)) {
                return new CustomerDTO(customer.name, customer.email, customer.phoneNumber, customer.ownedBikes);
            }
        }
        System.out.println("Customer not found");
        return null;
    }

    private boolean hasPhoneNumber(int phoneNumber, CustomerData customer) {
        return phoneNumber == customer.phoneNumber;
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
