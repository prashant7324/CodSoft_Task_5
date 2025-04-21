import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    // Student class to represent individual student
    static class Student {
        private String name;
        private String rollNumber;
        private String grade;
        private int age;

        // Constructor
        public Student(String name, String rollNumber, String grade, int age) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
            this.age = age;
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRollNumber() {
            return rollNumber;
        }

        public void setRollNumber(String rollNumber) {
            this.rollNumber = rollNumber;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        // Display student details
        public void displayStudentDetails() {
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
            System.out.println("Age: " + age);
        }
    }

    // StudentManagementSystem class to manage collection of students
    static class SMS {
        private ArrayList<Student> students;

        // Constructor
        public SMS() {
            students = new ArrayList<>();
        }

        // Add a student
        public void addStudent(Student student) {
            students.add(student);
            System.out.println("Student added: " + student.getName());
        }

        // Remove a student by roll number
        public void removeStudent(String rollNumber) {
            boolean found = false;
            for (Student student : students) {
                if (student.getRollNumber().equals(rollNumber)) {
                    students.remove(student);
                    System.out.println("Student removed: " + student.getName());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Student with roll number " + rollNumber + " not found.");
            }
        }

        // Search for a student by roll number
        public void searchStudent(String rollNumber) {
            boolean found = false;
            for (Student student : students) {
                if (student.getRollNumber().equals(rollNumber)) {
                    student.displayStudentDetails();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Student with roll number " + rollNumber + " not found.");
            }
        }

        // Display all students
        public void displayAllStudents() {
            if (students.isEmpty()) {
                System.out.println("No students to display.");
            } else {
                for (Student student : students) {
                    student.displayStudentDetails();
                    System.out.println("------------------------------");
                }
            }
        }
    }

    // Main method with user interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SMS sms = new SMS();
        
        while (true) {
            // Display menu
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Add Student
                    System.out.print("Enter student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    String rollNumber = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    
                    Student newStudent = new Student(name, rollNumber, grade, age);
                    sms.addStudent(newStudent);
                    break;

                case 2:
                    // Remove Student
                    System.out.print("Enter roll number of student to remove: ");
                    String removeRollNumber = scanner.nextLine();
                    sms.removeStudent(removeRollNumber);
                    break;

                case 3:
                    // Search for a Student
                    System.out.print("Enter roll number to search: ");
                    String searchRollNumber = scanner.nextLine();
                    sms.searchStudent(searchRollNumber);
                    break;

                case 4:
                    // Display all students
                    sms.displayAllStudents();
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
