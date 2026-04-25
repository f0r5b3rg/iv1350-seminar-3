package se.kth.iv1350.repairelectricbike.model;

/** 
 * Contains all data and methods for one customer.
 *
 */

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.repairelectricbike.integration.BikeDTO;
import se.kth.iv1350.repairelectricbike.integration.CustomerDTO;

public class Customer {
    private CustomerDTO customerDTO;

    public Customer(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    BikeDTO getBikeFromSerialNo(String bikeSerialNo) {
        for (BikeDTO bike : this.customerDTO.getOwnedBikes()) {
            if (bikeSerialNo.equals(bike.getSerialNo())) {
                return bike;
            }
        }
        return null;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    /**
     * Get the customer's name.
     *
     * @return the customer's name.
     */
    public String getName() {
        return this.customerDTO.getName();
    }

    /**
     * Get the customer's email.
     *
     * @return the customer's email.
     */
    public String getEmail() {
        return this.customerDTO.getEmail();
    }

    /**
     * Get the customer's phone number.
     *
     * @return the customer's phone number.
     */
    public String getPhoneNumber() {
        return this.customerDTO.getPhoneNumber();
    }

    /**
     * Get a list of the customer's owned bikes.
     *
     * @return a list containing the customer's owned bikes.
     */
    public List<BikeDTO> getOwnedBikes() {
        return this.customerDTO.getOwnedBikes();
    }

}
