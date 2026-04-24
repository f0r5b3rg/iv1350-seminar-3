package se.kth.iv1350.repairelectricbike.integration;

/**
 * Contains information about a customer.
 */

import java.util.ArrayList;
import java.util.List;

public final class CustomerDTO {
    private final String name;
    private final String email;
    private final int phoneNumber;
    private final List<BikeDTO> ownedBikes;

    /**
     * Creates a new instance of a customer DTO.
     *
     * @param name        The customer's name.
     * @param email       The customer's email.
     * @param phoneNumber The customer's phone number.
     * @param ownedBikes  The customer's bikes.
     */
    public CustomerDTO(String name, String email, int phoneNumber, List<BikeDTO> ownedBikes) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.ownedBikes = ownedBikes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("name: " + name + ", ");
        builder.append("email: " + email + ", ");
        builder.append("phoneNumber: " + phoneNumber + ", ");
        builder.append("ownedBikes: " + ownedBikes);
        return builder.toString();
    }

    /**
     * Get the customer's name.
     *
     * @return the customer's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the customer's email.
     *
     * @return the customer's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get the customer's phone number.
     *
     * @return the customer's phone number.
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get a list of the customer's owned bikes.
     *
     * @return a list containing the customer's owned bikes.
     */
    public List<BikeDTO> getOwnedBikes() {
        return ownedBikes;
    }
}
