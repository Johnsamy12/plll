import java.io.*;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public static User login() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter username: ");
        String enteredUsername = input.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = input.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("user.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String fileUsername = parts[0];
                    String filePassword = parts[1];
                    String fileRole = parts[2];

                    if (fileUsername.equals(enteredUsername) && filePassword.equals(enteredPassword)) {
                        System.out.println("Login successful! Role: " + fileRole);
                        return new User(fileUsername, filePassword, fileRole);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users file: " + e.getMessage());
        }

        System.out.println("Invalid username or password.");
        return null;
    }
}