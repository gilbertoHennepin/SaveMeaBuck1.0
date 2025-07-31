import java.util.Scanner;

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
    double radius = scanner.nextDouble();
    }
}
