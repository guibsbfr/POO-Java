package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1) + " data: ");
            System.out.print("Outsourced (y/n)? ");
            char ans = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (ans == 'y') {
                System.out.print("Additional charge: ");
                double charge = sc.nextDouble();

                Employee emp = new OutsourcedEmployee(name, hours, valuePerHour, charge);
                emp.payment();
                employees.add(emp);
            } else {
                Employee emp = new Employee(name, hours, valuePerHour);
                employees.add(emp);
            }
        }

        System.out.println();
        System.out.println("PAYMENTS: ");
        for (Employee emp: employees) {
            System.out.println(emp.getName() + " - $ " + emp.payment());
        }
    }
}