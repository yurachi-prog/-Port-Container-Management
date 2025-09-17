package Main_Package;

import java.util.ArrayDeque;
import java.util.Scanner;

public class portmanager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<container> containerStack = new ArrayDeque<>();
        ArrayDeque<ship> shipQueue = new ArrayDeque<>();

        int choice;
        do {
            System.out.println("\n=== Port Container Management System ===");
            System.out.println("[1] Store container (push)");
            System.out.println("[2] View port containers");
            System.out.println("[3] Register arriving ship (enqueue)");
            System.out.println("[4] View waiting ships");
            System.out.println("[5] Load next ship");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Container ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter Weight (kg): ");
                    int weight = sc.nextInt();
                    sc.nextLine();
                    container c = new container(id, desc, weight);
                    containerStack.push(c);
                    System.out.println("Stored: " + c);
                    break;

                case 2:
                    System.out.println("\nTOP →");
                    for (container con : containerStack) {
                        System.out.println(con);
                    }
                    System.out.println("← BOTTOM");
                    break;

                case 3:
                    System.out.print("Enter Ship Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Captain Name: ");
                    String captain = sc.nextLine();
                    ship s = new ship(name, captain);
                    shipQueue.offer(s);
                    System.out.println("Registered: " + s);
                    break;

                case 4:
                    System.out.println("\nFRONT →");
                    for (ship ship : shipQueue) {
                        System.out.println(ship);
                    }
                    System.out.println("← REAR");
                    break;

                case 5:
                    if (containerStack.isEmpty() || shipQueue.isEmpty()) {
                        System.out.println("Cannot load: Missing container or ship.");
                    } else {
                        container loadedContainer = containerStack.pop();
                        ship loadingShip = shipQueue.poll();
                        System.out.println("Loaded: " + loadedContainer + " → " + loadingShip);
                        System.out.println("Remaining containers: " + containerStack.size());
                        System.out.println("Remaining ships waiting: " + shipQueue.size());
                    }
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
