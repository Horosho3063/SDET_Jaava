interface Drivable {
    void drive();
    void stop();
}

interface Checkable {
    boolean isCheckRequired();
}

abstract class Vehicle {
    protected String model;
    protected int year;

    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public abstract void displayInfo();

    public int getVehicleAge() {
        int currentYear = 2024; // Для примера текущий год 2024
        return currentYear - year;
    }
}

class Car extends Vehicle implements Drivable, Checkable {
    private String fuelType;
    private int mileage;
    private static int carCount = 0;

    public Car(String model, int year, String fuelType, int mileage) {
        super(model, year);
        this.fuelType = fuelType;
        this.mileage = mileage;
        carCount++;
    }

    @Override
    public void drive() {
        System.out.println(model + " is driving.");
    }

    @Override
    public void stop() {
        System.out.println(model + " has stopped.");
    }

    @Override
    public boolean isCheckRequired() {
        return mileage > 10000;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car Model: " + model + ", Year: " + year + ", Fuel Type: " + fuelType);
    }

    public static int getCarCount() {
        return carCount;
    }

    public void checkMileage() {
        if (mileage > 15000) {
            System.out.println("Maintenance required soon.");
        } else if (mileage > 5000) {
            System.out.println("Mileage is within normal range.");
        } else {
            System.out.println("Vehicle is still new.");
        }
    }
}

class Truck extends Vehicle implements Drivable, Checkable {
    private int loadCapacity;
    private int mileage;
    private static int truckCount = 0;

    public Truck(String model, int year, int loadCapacity, int mileage) {
        super(model, year);
        this.loadCapacity = loadCapacity;
        this.mileage = mileage;
        truckCount++;
    }

    @Override
    public void drive() {
        System.out.println(model + " is transporting goods.");
    }

    @Override
    public void stop() {
        System.out.println(model + " has stopped after delivery.");
    }

    @Override
    public boolean isCheckRequired() {
        return mileage > 20000;
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck Model: " + model + ", Year: " + year + ", Load Capacity: " + loadCapacity + "kg");
    }

    public static int getTruckCount() {
        return truckCount;
    }

    public void checkLoadCapacity() {
        if (loadCapacity > 10000) {
            System.out.println("This truck can carry heavy loads.");
        } else {
            System.out.println("This truck is for light loads.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota Camry", 2020, "Petrol", 12000);
        Car car2 = new Car("Honda Civic", 2022, "Hybrid", 3000);
        Truck truck1 = new Truck("Volvo", 2019, 15000, 25000);

        car1.displayInfo();
        car1.drive();
        car1.checkMileage();
        System.out.println("Car check required: " + car1.isCheckRequired());
        car1.stop();

        car2.displayInfo();
        car2.drive();
        car2.checkMileage();
        System.out.println("Car check required: " + car2.isCheckRequired());
        car2.stop();

        truck1.displayInfo();
        truck1.drive();
        truck1.checkLoadCapacity();
        System.out.println("Truck check required: " + truck1.isCheckRequired());
        truck1.stop();

        System.out.println("Total cars created: " + Car.getCarCount());
        System.out.println("Total trucks created: " + Truck.getTruckCount());
    }
}
