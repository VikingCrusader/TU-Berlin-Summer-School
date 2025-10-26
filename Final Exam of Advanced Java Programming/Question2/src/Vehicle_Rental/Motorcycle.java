package Vehicle_Rental;

public class Motorcycle extends Vehicle {
    private int engineCapacity;

    //constructor
    public Motorcycle(String registrationNumber, String brand, double rentalPricePerDay, int engineCapacity) {
        super(registrationNumber, brand, rentalPricePerDay);
        this.engineCapacity = engineCapacity;
    }

    // getters and setters
    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    //toString

    @Override
    public String toString() {
        return "Motorcycle{" +
                "engineCapacity=" + engineCapacity +
                '}';
    }
}
