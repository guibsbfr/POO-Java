package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data: ");
            System.out.print("Individual or company (i/c)? ");
            char temp = sc.next().charAt(0);
            if (temp == 'i') {
                System.out.print(("Name: "));
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Anual income: ");
                double anualIncome = sc.nextDouble();
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();

                list.add(new Individual(name, anualIncome, healthExpenditures));
            }
            else {
                if (temp == 'c') {
                    System.out.print(("Name: "));
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Anual income: ");
                    double anualIncome = sc.nextDouble();
                    System.out.print("Number of employees: ");
                    int numberOfEmployees = sc.nextInt();

                    list.add(new Company(name, anualIncome, numberOfEmployees));
                }
            }
        }

        System.out.println("TAXES PAID: ");
        for (TaxPayer payers : list) {
            System.out.println(payers.getName() + ": $ " + String.format("%.2f", payers.tax()));
        }
        double totalTaxes = 0;
        for (TaxPayer totalTax : list) {
            totalTaxes += totalTax.tax();
        }
        System.out.println();
        System.out.print("TOTAL TAXES: $ " + String.format("%.2f", totalTaxes));

        sc.close();
    }
}