import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    private ArrayList<Double> grades = new ArrayList<>();

    // Method to add a grade
    public void addGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
            System.out.println("Grade added successfully.");
        } else {
            System.out.println("Invalid grade. Enter a value between 0 and 100.");
        }
    }

    // Calculate average grade
    public double calculateAverage() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.size();
    }

    // Find highest grade
    public double findHighest() {
        if (grades.isEmpty()) return 0;
        double max = grades.get(0);
        for (double g : grades) {
            if (g > max) {
                max = g;
            }
        }
        return max;
    }

    // Find lowest grade
    public double findLowest() {
        if (grades.isEmpty()) return 0;
        double min = grades.get(0);
        for (double g : grades) {
            if (g < min) {
                min = g;
            }
        }
        return min;
    }

    // Display all grades
    public void displayGrades() {
        if (grades.isEmpty()) {
            System.out.println("No grades entered yet.");
            return;
        }
        System.out.println("Grades entered:");
        for (int i = 0; i < grades.size(); i++) {
            System.out.printf("Student %d: %.2f%n", i + 1, grades.get(i));
        }
    }

    // Main menu and input loop
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Student Grade Tracker!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add grade");
            System.out.println("2. View grades");
            System.out.println("3. Show statistics");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter grade (0-100): ");
                    double grade = scanner.nextDouble();
                    addGrade(grade);
                    break;
                case 2:
                    displayGrades();
                    break;
                case 3:
                    if (grades.isEmpty()) {
                        System.out.println("No grades to show statistics.");
                    } else {
                        System.out.printf("Average grade: %.2f%n", calculateAverage());
                        System.out.printf("Highest grade: %.2f%n", findHighest());
                        System.out.printf("Lowest grade: %.2f%n", findLowest());
                    }
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentGradeTracker tracker = new StudentGradeTracker();
        tracker.run();
    }
}
