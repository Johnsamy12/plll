import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class oldcustomermodule {
    private final String fileName = "oldcustomer.txt";
    private Scanner scanner = new Scanner(System.in);

    public void payBill() {
        System.out.print("Enter Meter Code: ");
        String meterCode = scanner.nextLine();
        System.out.print("Enter Payment Status: ");
        String paymentStatus = scanner.nextLine();
        
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("MeterCode: " + meterCode + ", PaymentStatus: " + paymentStatus + "\n");
            System.out.println("Payment recorded is Done");
        } catch (IOException e) {
            System.out.println("Error writing payment: " + e.getMessage());
        }
    }

    public void enterReading() {
        System.out.print("Enter Meter Code: ");
        String meterCode = scanner.nextLine();
        System.out.print("Enter Meter Reading: ");
        String reading = scanner.nextLine();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("MeterCode: " + meterCode + ", Reading: " + reading + "\n");
            System.out.println("Meter reading recorded is Done!");
        } catch (IOException e) {
            System.out.println("Error writing reading: " + e.getMessage());
        }
    }

    public void complainBill() {
        System.out.print("Enter Meter Code: ");
        String meterCode = scanner.nextLine();
        System.out.print("Enter Problem: ");
        String complaint = scanner.nextLine();
        
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("MeterCode: " + meterCode + ", Problem: " + complaint + "\n");
            System.out.println("Complaint recorded is Done!");
        } catch (IOException e) {
            System.out.println("Error writing Problem: " + e.getMessage());
        }
    }
}