package Vehicle_Rental;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Vehicle v1 = new Vehicle("BER1234","Volkswagen",100.0);
        Vehicle v2 = new Vehicle("MUN5678","Mercedes Benz",130.0);
        Vehicle v3 = new Vehicle("FRA9876","BMW", 150.0);
        Vehicle v4 = new Vehicle("HAM6520","BMW",90.0);
        Vehicle v5 = new Vehicle("LEI6520","AUDI",90.0);
        Motorcycle m1 = new Motorcycle("DUS7809","MOTOKING", 45.0,500);
        Motorcycle m2 = new Motorcycle("HAM5233","SUZUKI", 35.0,300);
        Motorcycle m3 = new Motorcycle("STU8765","TOYOTA",60.0,300);
        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(v3);
        vehicles.add(v4);
        vehicles.add(m1);
        vehicles.add(m2);
        vehicles.add(m3);
        // search all BMW vehicles
        System.out.println("All the Vehicles whose brands are BMW: ");
        System.out.println(searchByBrand(vehicles, "BMW"));
        // search all VW vehicles
        System.out.println("All the Vehicles whose brands are VW: ");
        System.out.println(searchByBrand(vehicles, "Volkswagen"));
        // search all motorcycles with engine capacity 300
        System.out.println("All the Motorcycles whose capacity are 300:");
        System.out.println(searchByCapacity(vehicles, 300));
        // search all motorcycles with engine capacity 500
        System.out.println("All the Motorcycles whose capacity are 500:");
        System.out.println(searchByCapacity(vehicles, 500));
    }
    //search by brand method
    public static List<Vehicle> searchByBrand (List<Vehicle> vehicles, String brand) {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getBrand().toLowerCase().equals(brand.toLowerCase())) {
                vehicleList.add(v);
            }
        }
        return vehicleList;
    }
    //search by given engine capacity
    public static List<Motorcycle> searchByCapacity(ArrayList<Vehicle> vehicles, int capacity) {
        List<Motorcycle> motorcycleList = new ArrayList<>();
        vehicles.stream()
                .filter(vehicle -> vehicle instanceof Motorcycle) // using filter, keep only motorcycles
                .map(vehicle -> (Motorcycle) vehicle)              // cast to Motorcycle
                .filter(motorcycle -> motorcycle.getEngineCapacity() == capacity) // match capacity
                .forEach(motorcycleList::add);                     // add to result list
        return motorcycleList;
    }

}
