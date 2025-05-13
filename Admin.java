
/*import java.io.*;
import java.util.Scanner;

public class Admin {
    private Scanner scanner = new Scanner(System.in);
    private final String fileName = "operator.txt";  // هنا الملف اللي هتقرأ منه الفواتير
    private String admin;
    // 1. عرض جميع الفواتير لمنطقة معينة
    public void viewAllBills() {
        System.out.print("Enter the region name to view bills: ");
        String region = scanner.nextLine();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("admin.txt"))) {
            String line;
            System.out.println("Bills for region: " + region);
            while ((line = reader.readLine()) != null) {
                if (line.contains(region)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading bills: " + e.getMessage());
        }
    }

    // 2. عرض إجمالي المدفوعات
    public void viewTotalCollected() {
        double total = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                for (String part : parts) {
                    if (part.contains("PaymentAmount")) {
                        String amountStr = part.split(": ")[1];
                        total += Double.parseDouble(amountStr);
                    }
                }
            }
            System.out.println("Total collected payments: " + total);
        } catch (IOException e) {
            System.out.println("Error calculating total collected payments: " + e.getMessage());
        }
    }

    // 3. إنشاء إحصائيات الاستهلاك لمنطقة معينة
    public void viewConsumptionStats() {
        System.out.print("Enter the region name to view consumption statistics: ");
        String region = scanner.nextLine();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int totalReading = 0;
            int count = 0;
            
            while ((line = reader.readLine()) != null) {
                if (line.contains(region)) {
                    String[] parts = line.split(", ");
                    for (String part : parts) {
                        if (part.contains("Reading")) {
                            String readingStr = part.split(": ")[1];
                            totalReading += Integer.parseInt(readingStr);
                            count++;
                        }
                    }
                }
            }
            
            if (count > 0) {
                double avgConsumption = totalReading / (double) count;
                System.out.println("Average consumption for region " + region + ": " + avgConsumption);
            } else {
                System.out.println("No data found for region " + region);
            }
        } catch (IOException e) {
            System.out.println("Error calculating consumption statistics: " + e.getMessage());
        }
    }

    // 4. إدارة المستخدمين (إضافة/تحديث/حذف)
    public void manageUsers() {
        System.out.println("1. Add User");
        System.out.println("2. Update User");
        System.out.println("3. Delete User");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        switch (choice) {
            case 1:
                addUser();
                break;
            case 2:
                updateUser();
                break;
            case 3:
                deleteUser();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void addUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (OldCustomer, NewCustomer, Operator, Admin): ");
        String role = scanner.nextLine();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write("Username: " + username + ", Password: " + password + ", Role: " + role + "\n");
            System.out.println("User added successfully!");
        } catch (IOException e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }

    private void updateUser() {
        System.out.print("Enter username to update: ");
        String username = scanner.nextLine();
        
        // Load users from file and update the relevant user
        // You will need to read the file, update the user's details, and then rewrite the file
    }

    private void deleteUser() {
        System.out.print("Enter username to delete: ");
        String username = scanner.nextLine();
        
        // Load users from file, remove the user, and rewrite the file
    }
}*/




import java.io.*;
import java.util.*;

public class Admin {
    private final String operatorFileName = "operator.txt"; 
    private final String adminFileName = "admin.txt"; 
    private Scanner scanner = new Scanner(System.in);

    
    public void viewAllBills() {
        System.out.println("Viewing all bills from operator.txt:");
        try (BufferedReader reader = new BufferedReader(new FileReader(operatorFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
               
                writeToAdminFile("Viewed bill: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from operator.txt: " + e.getMessage());
        }
    }

  
    public void viewTotalCollected() {
        double totalCollected = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader(operatorFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                for (String part : parts) {
                    if (part.trim().startsWith("PaymentAmount")) {
                        String amountStr = part.split(":")[1].trim();
                        try {
                            double amount = Double.parseDouble(amountStr);
                            totalCollected += amount;
                        } catch (NumberFormatException e) {
                            System.out.println("Error parsing payment amount: " + e.getMessage());
                        }
                    }
                }
            }
            System.out.println("Total collected: " + totalCollected);
            
            writeToAdminFile("Total collected: " + totalCollected);
        } catch (IOException e) {
            System.out.println("Error reading from operator.txt: " + e.getMessage());
        }
    }

  
    public void viewConsumptionStats() {
        System.out.print("Enter the region name to view consumption statistics: ");
        String region = scanner.nextLine();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(operatorFileName))) {
            String line;
            int totalReading = 0;
            int count = 0;
            
            while ((line = reader.readLine()) != null) {
                if (line.contains(region)) {
                    String[] parts = line.split(", ");
                    for (String part : parts) {
                        if (part.contains("Reading")) {
                            String readingStr = part.split(": ")[1];
                            totalReading += Integer.parseInt(readingStr);
                            count++;
                        }
                    }
                }
            }
            
            if (count > 0) {
                double avgConsumption = totalReading / (double) count;
                System.out.println("Average consumption for region " + region + ": " + avgConsumption);
            } else {
                System.out.println("No data found for region " + region);
            }
        } catch (IOException e) {
            System.out.println("Error calculating consumption statistics: " + e.getMessage());
        }
    }

    
    private void writeToAdminFile(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(adminFileName, true))) {
            writer.write(data + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to admin.txt: " + e.getMessage());
        }
    }

     
    public void manageUsers() {
        System.out.println("1. Add User");
        System.out.println("2. Update User");
        System.out.println("3. Delete User");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        
        switch (choice) {
            case 1:
                addUser();
                break;
            case 2:
                updateUser();
                break;
            case 3:
                deleteUser();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void addUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (OldCustomer, NewCustomer, Operator, Admin): ");
        String role = scanner.nextLine();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user.txt", true))) {
            writer.write(username + "," + password + "," + role + "\n");
            System.out.println("User added successfully!");
        } catch (IOException e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }

  /* private void updateUser() {
    System.out.print("Enter username to update: ");
    String usernametoupdate = scanner.nextLine();
    boolean found = false;

    try (BufferedReader reader = new BufferedReader(new FileReader("user.txt"))) {
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 1) {
                String username = parts[0].trim();
                if (username.equalsIgnoreCase(usernametoupdate.trim())) {
                    found = true;
                    break;
                }
            }
        }

        if (found) {
            System.out.println("Username found! Proceeding with update...");
            System.out.println("1.edit username\n 2.edit password\n 3. edit role\n 4.exit");
            System.out.println("Enter choice");
            int choice = scanner.nextInt();
            scanner.nextLine();
            String username;
            String password;
            String role;

            while(true){
            switch (choice){
                case 1 -> {
                    System.out.println("Enter the new username");
                    username = scanner.nextLine();
                    FileWriter writer = new FileWriter("example.txt");
                     writer.write();
                    }
                case 2 -> { 
                    System.out.println("Enter the new password");
                    password = scanner.nextLine();
                    }
                case 3 -> {
                    System.out.println("Enter the new role");
                    role = scanner.nextLine();
                    }
                case 4 -> {
                    return;
                    }
                default -> System.out.println("wrong choice");
                    
            }
            
            }    
            
            
            // Add update logic here
        } else {
            System.out.println("Username not found.");
        }

    } catch (IOException e) {
        System.out.println("Error reading the file.");
    }
}

        
 */       
      
    
   private void updateUser() {
    System.out.print("Enter username to update: ");
    String usernameToUpdate = scanner.nextLine().trim();

    File inputFile = new File("user.txt");
    File tempFile = new File("temp_user.txt");

    boolean found = false;

    try (
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
    ) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 3 && parts[0].trim().equalsIgnoreCase(usernameToUpdate)) {
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine().trim();
                System.out.print("Enter new role: ");
                String newRole = scanner.nextLine().trim();
                writer.write(usernameToUpdate + "," + newPassword + "," + newRole);
                found = true;
            } else {
                writer.write(line);
            }
            writer.newLine();
        }

        writer.flush();
    } catch (IOException e) {
        System.out.println("Error updating user: " + e.getMessage());
        return;
    }

    // Replace old file with updated one
    if (found) {
        if (inputFile.delete() && tempFile.renameTo(inputFile)) {
            System.out.println("User updated successfully!");
        } else {
            System.out.println("Error replacing original file.");
        }
    } else {
        tempFile.delete();
        System.out.println("User not found.");
    }
}

       
    

   private void deleteUser() {
    System.out.print("Enter username to delete: ");
    String usernameToDelete = scanner.nextLine().trim();

    File inputFile = new File("user.txt");
    File tempFile = new File("temp_user.txt");

    boolean found = false;

    try (
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
    ) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 3 && parts[0].trim().equalsIgnoreCase(usernameToDelete)) {
                found = true;
                // Skip writing this line (i.e., delete it)
                continue;
            }
            writer.write(line);
            writer.newLine();
        }

        writer.flush();
    } catch (IOException e) {
        System.out.println("Error deleting user: " + e.getMessage());
        return;
    }

    // Replace original file with updated one
    if (found) {
        if (inputFile.delete() && tempFile.renameTo(inputFile)) {
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("Error replacing original file.");
        }
    } else {
        tempFile.delete();
        System.out.println("User not found.");
    }
}
}

        
        
    