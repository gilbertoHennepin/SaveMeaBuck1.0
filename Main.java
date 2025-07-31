import java.util.Scanner;
import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter your address");
    String address = scanner.nextLine();

    System.out.println("Enter transportation method (Car, walk, bike/scooter)");
    String transport = scanner.nextLine();

    if ("walk".equalsIgnoreCase(transport)) {
    System.out.println("Enter max distance you're willing to walk (miles)" + "\n" +
    "The average human walks a mile in 15-22 minutes ");
    } else if ("bike".equalsIgnoreCase(transport) || "bike".equalsIgnoreCase(transport)) {
        System.out.println("Enter the max distance you're willing to bike/scooter (miles) " + "\n" +
        "The average person can bike a mile in 4-6 minutes at 9/14 mpb" + "\n" +
        "The average person scooter can  travel a mile in 3-6 minutes at 15/18 mph");
    } else if ("car".equalsIgnoreCase(transport)) {
        System.out.println("Enter max distance you're wiling to drive (miles)" + "\n" +
        "The average car can travel a mile in 1-2 minutes ");
    } else {
        System.out.println(" PLease enter Car, Walk, Scooter, or Bike");
    }

    // Read radius input
    double radius = scanner.nextDouble();

    // Simulated user location (hardcoded for now)
    double userLat = 44.85;
    double userLon = -93.28;

    // Restaurant data
    List<Restaurant> allRestaurants = new ArrayList<>();
    allRestaurants.add(new Restaurant("McDonald's", "123 Main St", 44.86, -93.28, "Free fries!"));
    allRestaurants.add(new Restaurant("Taco Bell", "456 Elm St", 44.82, -93.29, "Buy 1 get 1 taco!"));
    allRestaurants.add(new Restaurant("Burger King", "789 Oak Ave", 44.75, -93.31, "Whopper for $3!"));

    // Filter and display restaurants
    System.out.println("\nNearby Fast Food Restaurants with Promotions:");
    for (Restaurant r : allRestaurants) {
        double dist = getDistance(userLat, userLon, r.latitude, r.longitude);
        if (dist <= radius) {
            System.out.printf("- %s (%s)\n  Deal: %s\n  Distance: %.2f miles\n\n",
                    r.name, r.address, r.promo, dist);
        }
    }
}

// Haversine formula
public static double getDistance(double lat1, double lon1, double lat2, double lon2) {
    final int EARTH_RADIUS = 3959; // in miles

    double dLat = Math.toRadians(lat2 - lat1);
    double dLon = Math.toRadians(lon2 - lon1);

    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
            * Math.sin(dLon / 2) * Math.sin(dLon / 2);

    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    return EARTH_RADIUS * c;
}

// Restaurant class
static class Restaurant {
    String name;
    String address;
    double latitude;
    double longitude;
    String promo;

    public Restaurant(String name, String address, double lat, double lon, String promo) {
        this.name = name;
        this.address = address;
        this.latitude = lat;
        this.longitude = lon;
        this.promo = promo;
    }
}
}
