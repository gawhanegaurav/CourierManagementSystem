package main;

import java.util.Scanner;

public class UserAuthentication {

    // Dummy user data (replace this with your actual user data)
    private static final String[] userDatabase = {"john.doe@example.com:password123", "jane.smith@example.com:pass456", "admin@example.com:admin123"};

    public static void main(String[] args) {
        // Get user input for login credentials
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Perform user authentication
        boolean isAuthenticated = authenticateUser(email, password);

        // Display the authentication result
        if (isAuthenticated) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed. Please check your credentials.");
        }

        // Close the scanner
        scanner.close();
    }

    // Method to authenticate user based on email and password
    private static boolean authenticateUser(String email, String password) {
        String credentials = email + ":" + password;

        // Check if the user credentials exist in the user database
        for (String user : userDatabase) {
            if (user.equals(credentials)) {
                return true; // Authentication successful
            }
        }
        return false; // Authentication failed
    }
}
