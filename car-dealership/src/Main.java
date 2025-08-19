import static model.Car.*;

import java.util.Scanner;

import model.Car;
import model.Car.BodyType;
import model.CarDealership;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String make = promptForMake(scanner);
        String model = promptForModel(scanner);
        BodyType bodyType = promptForBodyType(scanner);
        int year = promptForYear(scanner);
        double price = promptForPrice(scanner);

        Car newCar = new Car(make, model, bodyType, year, price);

        CarDealership dealership = new CarDealership();
        dealership.addCar(newCar);

        System.out.println("Car added to the dealership: " + newCar.getMake() + " " + newCar.getModel());
    }

    public static boolean isNullOrBlank(String input) {
        return input.isBlank() || input == null;

    }

    public static boolean invalidYear(int year) {
        return year < MIN_YEAR;
    }

    public static boolean invalidPrice(double price) {
        return price < MIN_PRICE || price > MAX_PRICE;
    }

    public static boolean invalidBodyType(String bodyType) {
        try {
            String UpperBodyType = bodyType.toUpperCase();
            Car.BodyType.valueOf(UpperBodyType);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    public static BodyType promptForBodyType(Scanner scanner) {
        while (true) {
            System.out.print("\nPlease enter a valid car body type: ");
            String bodyType = scanner.nextLine();
            if (!invalidBodyType(bodyType)) {
                return BodyType.valueOf(bodyType.toUpperCase());
            } else {
                System.out.println("Invalid Body type");
            }
        }
    }

    public static String promptForMake(Scanner scanner) {
        while (true) {
            System.out.print("\nPlease enter a valid car make: ");
            String make = scanner.nextLine();
            if (!isNullOrBlank(make)) {
                return make;
            }
            System.out.println("Make cannot be empty");
        }
    }

    public static String promptForModel(Scanner scanner) {
        while (true) {
            System.out.print("\nPlease enter a valid car model: ");
            String model = scanner.nextLine();
            if (!isNullOrBlank(model)) {
                return model;
            }
            System.out.println("Model cannot be empty");
        }
    }

    public static int promptForYear(Scanner scanner) {
        while (true) {
            System.out.print("\nPlease enter a valid production year: ");
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                continue;
            }

            int year = scanner.nextInt();

            if (!invalidYear(year)) {
                return year;
            }
            System.out.println("Enter valid year");
        }
    }

    public static double promptForPrice(Scanner scanner) {
        while (true) {
            System.out.print("\nPlease enter a valid car price: ");
            if (!scanner.hasNextDouble()) {
                scanner.nextLine();
                continue;
            }

            double price = scanner.nextDouble();

            if (!invalidPrice(price)) {
                return price;
            }
            System.out.println("Enter valid price from 0 to 200 000");
        }
    }

}