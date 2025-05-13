import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NewCustomermodule {
    private final String fileName = "newcustomer.txt";
    private Scanner scanner = new Scanner(System.in);

    public void addNewCustomer() {
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Customer Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Customer Contract Number: ");
        String contractNumber = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Name: " + name + ", Address: " + address + ", ContractNumber: " + contractNumber + "\n");
            System.out.println("New customer added is Done!");
        } catch (IOException e) {
            System.out.println("Error writing new customer: " + e.getMessage());
        }
    }

    public void notifyMeterReady() {
        System.out.print("Enter Customer Contract Number: ");
        String contractNumber = scanner.nextLine();

        System.out.println("Sending email notification to customer with contract number: " + contractNumber);
        
    }
}