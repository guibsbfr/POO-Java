package application;

import entitites.Course;
import entitites.Enrollment;
import entitites.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter course data: ");
        System.out.print("Course ID: ");
        int id = sc.nextInt();
        System.out.print("Course name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Instructor: ");
        String instructor = sc.nextLine();

        Course course = new Course(id, instructor, name);

        System.out.println();
        System.out.print("How many students to enroll? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter student #" + (i+1) + ":");
            System.out.print("ID: ");
            int studentId = sc.nextInt();
            System.out.print("Name: ");
            sc.nextLine();
            String studentName = sc.nextLine();
            System.out.print("Email: ");
            String studentEmail = sc.nextLine();
            LocalDate enrollmentDate = LocalDate.now();
            System.out.println();

            Student student = new Student(studentId, studentName, studentEmail);
            Enrollment enrollment = new Enrollment(course, enrollmentDate, student);
            course.addEnrollment(enrollment);
        }

        System.out.print(course);
    }
}