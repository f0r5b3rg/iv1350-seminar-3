package se.kth.iv1350.repairelectricbike.integration;

/**
 * Contains information about a bike.
 */

import java.util.ArrayList;
import java.util.List;

public final class BikeDTO {
    private final String brand;
    private final String model;
    private final String serialNo;

    /**
     * Creates a new instance of a customer.
     *
     * @param brand    The bike's brand.
     * @param model    The bike's model.
     * @param serialNo The bike's serial number.
     */

    public BikeDTO(String brand, String model, String serialNo) {
        this.brand = brand;
        this.model = model;
        this.serialNo = serialNo;
    }

    @Override
    public String toString() {
        return "brand: " + brand + ", " +
                "model: " + model + ", " +
                "serialNo: " + serialNo;
    }

    /**
     * Get the bike's brand.
     *
     * @return the bike's brand.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Get the bike's model.
     *
     * @return the bike's model.
     */
    public String getModel() {
        return model;
    }

    /**
     * Get the serial no.
     *
     * @return the serial no.
     */
    public String getSerialNo() {
        return serialNo;
    }
}
