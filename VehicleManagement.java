import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class VehicleManagement {
   public static void main(String[] args) {
      List<Vehicle> vehicleList = new ArrayList<>();
      Scanner e = new Scanner(System.in);
      Scanner sc = new Scanner(System.in);
      Scanner h = new Scanner(System.in);
   
      int choice;
      do {
         System.out.println("Menu:");
         System.out.println("1. Add a vehicle");
         System.out.println("2. Display a list of vehicle details");
         System.out.println("3. Delete a vehicle");
         System.out.println("4. Sort vehicle list by age");
         System.out.println("5. Quit");
         System.out.print("Enter your choice: ");
         choice = e.nextInt();
         e.nextLine();
      
         switch (choice) {
            case 1:
               System.out.print("Enter registration number: ");
               String regNo = e.nextLine();
            
               System.out.print("Enter make: ");
               String make = e.nextLine();
            
               System.out.print("Enter year of manufacture: ");
               int yearOfManufacture = sc.nextInt();
            
               System.out.print("Enter value: ");
               double value = sc.nextDouble();
               sc.nextLine();
            
               Vehicle newVehicle = new Vehicle(regNo, make, yearOfManufacture, value);
               vehicleList.add(newVehicle);
            
               System.out.println("Vehicle added successfully!");
               break;
            case 2:
               if (vehicleList.isEmpty()) {
                  System.out.println("No vehicles available.");
               } else {
                  System.out.println("List of vehicle details:");
                  for (Vehicle vehicle : vehicleList) {
                     System.out.println("Registration Number: " + vehicle.getRegNo() +", "+ " Make: " + vehicle.getMake() +", " +     " Year of Manufacture: " + vehicle.getYearOfManufacture() +", " +  " Value: " + vehicle.getValue());
                     
                  }
               }
               break;
            case 3:
               if (vehicleList.isEmpty()) {
                  System.out.println("No vehicles available to delete.");
               } else {
                  System.out.print("Enter the index of the vehicle to delete: ");
                  int indexToDelete = e.nextInt();
                  e.nextLine(); // Consume the newline character
               
                  if (indexToDelete >= 0 && indexToDelete < vehicleList.size()) {
                     Vehicle deletedVehicle = vehicleList.remove(indexToDelete);
                     System.out.println("Vehicle deleted successfully!");
                  } else {
                     System.out.println("Invalid index. Please enter a valid index.");
                  }
               }
               break;
            case 4:
               if (vehicleList.isEmpty()) {
                  System.out.println("No vehicles available to sort.");
               } else {
                  boolean sortMenu = true;
                  do {
                     System.out.println("Sort Menu:");
                     System.out.println("1. Sort by age (ascending)");
                     System.out.println("2. Sort by age (descending)");
                     System.out.println("3. Back to main menu");
                     System.out.print("Enter your choice: ");
                     int sortChoice = h.nextInt();
                     h.nextLine();
                     switch (sortChoice) {
                        case 1:
                           Collections.sort(vehicleList, Comparator.comparingInt(Vehicle::getYearOfManufacture));
                           displaySortedVehicleList(vehicleList, "ascending");
                           break;
                        case 2:
                           Collections.sort(vehicleList, Comparator.comparingInt(Vehicle::getYearOfManufacture).reversed());
                           displaySortedVehicleList(vehicleList, "descending");
                           break;
                        case 3:
                           sortMenu = false;
                           System.out.print("Returning to main menu...");
                           break;
                        default:
                           System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                           break;
                     }
                  } while (sortMenu);
                  
               }
               break;
               
               
               
            default:
               System.out.println("Exiting program...");
         }
      } while (choice != 5);
   
      e.close();
      h.close();
      sc.close();
   }

   private static void displaySortedVehicleList(List<Vehicle> vehicles, String order) {
      System.out.println("List of vehicle details sorted by age (" + order + "):");
      for (Vehicle vehicle : vehicles) {
         System.out.println("Reg No: " + vehicle.getRegNo() +
               ", Make: " + vehicle.getMake() +
                ", Year of Manufacture: " + vehicle.getYearOfManufacture() +
                ", Value: Php" + vehicle.getValue());
      }
   }
}