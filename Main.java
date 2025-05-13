
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Electricity Billing System!");
        
        Admin admin = new Admin();
        User user = User.login();

        if (user != null) {
            System.out.println("Login successful!");
            switch (user.getRole()) {
                case "OldCustomer":
                    oldCustomerModule();
                    break;
                case "NewCustomer":
                    newCustomerModule();
                    break;
                case "Operator":
                    operatorModule();
                    break;
                case "Admin":
                    adminModule();
                    break;
                default:
                    System.out.println("Unknown role.");
            }
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void oldCustomerModule() {
        Scanner scanner = new Scanner(System.in);
        oldcustomermodule oldCustomer = new oldcustomermodule(); 

        System.out.println("Welcome to Old Customer Module.");
        System.out.println("1. Pay Bill");
        System.out.println("2. Enter Meter Reading");
        System.out.println("3. Problem about Bill");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                oldCustomer.payBill();
                break;
            case 2:
                oldCustomer.enterReading(); 
                break;
            case 3:
                oldCustomer.complainBill();  
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void newCustomerModule() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to New Customer Module.");
        System.out.println("1. Register New Customer");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                registerNewCustomer();
                break;
            case 2:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void operatorModule() {
        Scanner scanner = new Scanner(System.in);
        OperatorModule operator = new OperatorModule();
        while(true){
        System.out.println("Welcome to Operator Module.");
        System.out.println("1. Collect Payments");
        System.out.println("2. Print Bill");
        System.out.println("3. View Regional Bills");
        System.out.println("4. Validate Meter Reading");
        System.out.println("5. Define Tariff");
        System.out.println("6. Stop Meter / Cancel Subscription");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                operator.collectPayment();
                break;
            case 2:
                operator.printBill();
                break;
            case 3:
                operator.viewRegionalBills();
                break;
            case 4:
                operator.validateReading();
                break;
            case 5:
                operator.defineTariff();
                break;
            case 6:
                operator.stopMeter();
                break;
            case 7:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }
    }

    private static void adminModule() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
        System.out.println("Welcome to Admin Module.");
        System.out.println("1. View All Bills");
        System.out.println("2. View Total Collected");
        System.out.println("3. View Consumption Statistics");
        System.out.println("4. Manage Users");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        Admin admin = new Admin();
        switch (choice) {
            case 1:
                admin.viewAllBills();
                break;
            case 2:
                admin.viewTotalCollected();
                break;
            case 3:
                admin.viewConsumptionStats();
                break;
            case 4:
                admin.manageUsers();
                break;
            case 5:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }
    }

    private static void registerNewCustomer(){
        NewCustomermodule newCustomer = new NewCustomermodule();
        newCustomer.addNewCustomer();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();
        System.out.println("New customer registered: " + name + ", " + address);
    }
}































































