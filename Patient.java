public class Patient {
    // Existing fields
    private int id;        // patient's ID
    private String name;   // patient's full name
    private int birthYear; // patient's year of birth (CE)
    private double height; // patient's height in centimeters
    private double weight; // patient's weight in kilograms

    // New fields
    private String bloodGroup;
    private String phoneNumber;



    // Constructor with all fields (using chaining)
    public Patient(int id, String name, int birthYear, double height, double weight, String bloodGroup, String phoneNumber) {
        this(id, name, birthYear, height, weight); // Chain to simpler constructor
        setBloodGroup(bloodGroup);
        setPhoneNumber(phoneNumber);
    }

    // Original constructor with validation
    public Patient(int id, String name, int birthYear, double height, double weight) {
        this.id = id;
        this.name = (name != null) ? name : "Unknown";

        // Validate birth year (reasonable range: 1900-2025)
        if (birthYear >= 1900 && birthYear <= 2025) {
            this.birthYear = birthYear;
        } else {
            this.birthYear = 2000; // default value
        }

        // Validate height (60-250 cm is reasonable range)
        if (height >= 60 && height <= 250) {
            this.height = height;
        } else {
            this.height = 170; // default value
        }

        // Validate weight (5-300 kg is reasonable range)
        if (weight >= 5 && weight <= 300) {
            this.weight = weight;
        } else {
            this.weight = 70; // default value
        }

        // Initialize new fields to null (will be set by full constructor or setters)
        this.bloodGroup = null;
        this.phoneNumber = null;
    }

    // Getters for existing fields
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    // Getters for new fields
    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters for new fields with validation
    public void setBloodGroup(String bloodGroup) {
        if (bloodGroup != null && !bloodGroup.trim().isEmpty()) {
            this.bloodGroup = bloodGroup.toUpperCase().trim();
        } else {
            this.bloodGroup = null;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = (phoneNumber != null && !phoneNumber.trim().isEmpty()) ?
                phoneNumber.trim() : null;
    }

    // BMI calculation method
    public double getBMI() {
        double heightInMeters = height / 100.0;
        return weight / (heightInMeters * heightInMeters);
    }

    // Calculate age based on current year
    public int getAge(int currentYear) {
        if (currentYear >= birthYear) {
            return currentYear - birthYear;
        } else {
            return 0; // Return 0 for invalid current year
        }
    }

    // Display patient details
    public void displayDetails(int currentYear) {
        System.out.println("=== Patient Details ===");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + getAge(currentYear) + " years");
        System.out.println("Height: " + height + " cm");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Blood Group: " + (bloodGroup != null ? bloodGroup : "Not specified"));
        System.out.println("Phone: " + (phoneNumber != null ? phoneNumber : "Not specified"));
        System.out.printf("BMI: %.2f%n", getBMI());
        System.out.println("========================");
    }

    // Overloaded displayDetails without current year (uses 2025 as default)
    public void displayDetails() {
        displayDetails(2025);
    }
}
