public class Main {
    public static void main(String[] args) {
        // Example usage as specified in requirements
        Patient patient = new Patient(1001, "Khaimook", 2006, 159, 41.3, "O", "062-651-4941");
        System.out.printf("Patient BMI: %.2f%n", patient.getBMI());

        System.out.println("\n========================================");

        // Create more patients to demonstrate functionality
        Patient patient1 = new Patient(1001, "Khaimook", 2006, 199.5, 40.3, "O+", "0626514941");
        Patient patient2 = new Patient(1002, "Jaemin", 2000, 167.0, 60.5);
        Patient patient3 = new Patient(1003, "Jaehyun", 1997, 182.0, 71.2, "B-", "123-456-7890");

        // Display patient details
        System.out.println("Displaying all patient details:");
        patient1.displayDetails();
        patient2.displayDetails();
        patient3.displayDetails();

        // Demonstrate BMI calculations
        System.out.println("BMI Information:");
        System.out.printf("%s's BMI: %.1f%n", patient1.getName(), patient1.getBMI());
        System.out.printf("%s's BMI: %.1f%n", patient2.getName(), patient2.getBMI());
        System.out.printf("%s's BMI: %.1f%n", patient3.getName(), patient3.getBMI());

        // Update information using setters
        System.out.println("\nUpdating Jaemin's information:");
        patient2.setBloodGroup("O+");
        patient2.setPhoneNumber("987654321");
        patient2.displayDetails();

        // Test getter methods for new fields
        System.out.println("\nTesting new getter methods:");
        System.out.println("Khaimook's Blood Group: " + patient1.getBloodGroup());
        System.out.println("Khaimook's Phone: " + patient1.getPhoneNumber());
        System.out.println("Jaehyun's Blood Group: " + patient3.getBloodGroup());
        System.out.println("Jaehyun's Phone: " + patient3.getPhoneNumber());
    }
}
