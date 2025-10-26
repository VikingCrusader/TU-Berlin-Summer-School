package Vehicle_Rental;

public class Vehicle {
    private String registrationNumber;
    private String brand;
    private double rentalPricePerDay;

    // Constructor
    public Vehicle(String registrationNumber, String brand, double rentalPricePerDay) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    //Getters and Setters

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(double rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }
    // toString
    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", rentalPricePerDay=" + rentalPricePerDay +
                '}';
    }
}
