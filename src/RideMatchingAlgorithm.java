import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Define a Driver class to hold driver information
class Driver {
    String name;
    double latitude;
    double longitude;
    double rating;
    String carType;
    boolean isAvailable;

    public Driver(String name, double latitude, double longitude, double rating, String carType, boolean isAvailable) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rating = rating;
        this.carType = carType;
        this.isAvailable = isAvailable;
    }

    // Distance calculation using Haversine formula
    public double distanceTo(double riderLat, double riderLong) {
        final int R = 6371; // Radius of the earth in km
        double latDistance = Math.toRadians(riderLat - this.latitude);
        double lonDistance = Math.toRadians(riderLong - this.longitude);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(riderLat)) * Math.cos(Math.toRadians(this.latitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Distance in kilometers
    }

    @Override
    public String toString() {
        return "Driver{name='" + name + '\'' +
                ", rating=" + rating +
                ", carType='" + carType + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

// Define a class to hold the matching logic
public class RideMatchingAlgorithm {

    // Sort to match a rider to the closest and highest-rated driver
    public static List<Driver> sortRiders(double riderLat, double riderLong, String preferredCarType, List<Driver> drivers) {
        // Only available drivers
        // Filter based on car type
        // Sort by proximity
        // Then by rating
        return drivers.stream()
                .filter(driver -> driver.isAvailable)  // Only available drivers
                .filter(driver -> driver.carType.equals(preferredCarType))
                .sorted(Comparator.comparingDouble((Driver d) -> d.distanceTo(riderLat, riderLong)) // Sort by proximity
                        .thenComparingDouble(d -> -d.rating))
                .collect(Collectors.toList()); // Return the first match or null if no driver is found
    }

    // Method to match a rider to the closest and highest-rated driver
    public static Driver matchRider(double riderLat, double riderLong, String preferredCarType, List<Driver> drivers) {
        // Only available drivers
        // Filter based on car type
        // Sort by proximity
        // Then by rating
        return drivers.stream()
                .filter(driver -> driver.isAvailable)  // Only available drivers
                .filter(driver -> driver.carType.equals(preferredCarType))
                .min(Comparator.comparingDouble((Driver d) -> d.distanceTo(riderLat, riderLong)) // Sort by proximity
                        .thenComparingDouble(d -> -d.rating))
                .orElse(null); // Return the first match or null if no driver is found
    }

    public static void main(String[] args) {
        // Sample drivers list
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Driver A", 40.7128, -74.0060, 1.8, "Sedan", true)); // NYC
        drivers.add(new Driver("Driver B", 40.7328, -74.0160, 4.6, "Sedan", true)); // Nearby NYC
        drivers.add(new Driver("Driver C", 34.0522, -118.2437, 4.9, "SUV", true));  // LA
        drivers.add(new Driver("Driver D", 40.7328, -74.0160, 4.9, "Sedan", true)); // Same as Driver B, but higher rating
        drivers.add(new Driver("Driver E", 40.7128, -74.0060, 4.5, "SUV", false));  // Not available
        drivers.add(new Driver("Driver F", 40.7128, -74.0060, 4.8, "Sedan", true)); // NYC

        // Rider's location and preferences
        double riderLat = 40.730610;  // New York City, NY
        double riderLong = -73.935242;
        String preferredCarType = "Sedan";

        // Match rider to a driver
        Driver matchedDriver = matchRider(riderLat, riderLong, preferredCarType, drivers);

        // Print the matched driver details
        if (matchedDriver != null) {
            System.out.println("Matched Driver: " + matchedDriver);
        } else {
            System.out.println("No available drivers found.");
        }

        // Sort Drivers
        List<Driver> sortedDrivers = sortRiders(riderLat, riderLong, preferredCarType, drivers);
        System.out.println("Sorted Drivers - ");
        sortedDrivers.forEach(System.out::println);

    }
}
