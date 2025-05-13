import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OperatorModule {
    private final String fileName = "operator.txt";
    private Scanner scanner = new Scanner(System.in);
    private String reading;

    public void collectPayment() {
        System.out.print("Enter Meter Code: ");
        String meterCode = scanner.nextLine();
        System.out.print("Enter Payment Amount: ");
        double amount = scanner.nextDouble();
        
        
             try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            //FileWriter writer = new FileWriter(fileName, true);
            writer.write("MeterCode: " + meterCode + ", PaymentAmount: " + amount + "\n");
            writer.close();
            System.out.println("Payment collected successfully!");
        } catch (IOException e) {
            System.out.println("Error writing payment: " + e.getMessage());
        }
    }

    public void printBill() {
        System.out.print("Enter Meter Code: ");
        String meterCode = scanner.nextLine();
        
        System.out.println("Printing bill for Meter Code: " + meterCode);
        
    }
    
  
     
     public void viewRegionalBills() {
    // تطلب من المشغل إدخال اسم المنطقة
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Region: ");
    String region = scanner.nextLine();
    System.out.print("Enter Reading: ");
     int reading = scanner.nextInt();
    

    
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("operator.txt", true))) {
        writer.write("Region: " + region + "\n");
        writer.write("Meter Reading: " + reading + "\n\n");
        System.out.println("Region saved to file.");
    } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
    }
}
  

    public void validateReading() {
        System.out.print("Enter Meter Code: ");
        String meterCode = scanner.nextLine();
        System.out.print("Enter Meter Reading: ");
        String reading = scanner.nextLine();
        
        System.out.println("Validating reading for Meter Code: " + meterCode + " with Reading: " + reading);
        
    }

    public void defineTariff() {
        System.out.print("Enter Meter Code: ");
        String meterCode = scanner.nextLine();
        System.out.print("Enter Tariff Rate: ");
        double tariffRate = scanner.nextDouble();
        
        System.out.println("Tariff for Meter Code " + meterCode + " set to " + tariffRate);
       
    }

    public void stopMeter() {
        System.out.print("Enter Meter Code to Stop: ");
        String meterCode = scanner.nextLine();
        
        System.out.println("Meter with Meter Code " + meterCode + " stopped.");
      
    }

    public void cancelSubscription() {
        System.out.print("Enter Meter Code to Cancel Subscription: ");
        String meterCode = scanner.nextLine();
        
        System.out.println("Subscription for Meter Code " + meterCode + " cancelled.");
      
    }
}