package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char temp = sc.next().charAt(0);
            if (temp == 'c') {
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();

                Product commonProduct = new Product(name, price);
                list.add(commonProduct);
            } else {
                if (temp == 'u') {
                    System.out.print("Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    LocalDate manufactureDate = LocalDate.parse(sc.next(), fmt);

                    Product usedProduct = new UsedProduct(name, price, manufactureDate);
                    list.add(usedProduct);
                } else {
                    if (temp == 'i') {
                        System.out.print("Name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        System.out.print("Customs fee: ");
                        double customsFee = sc.nextDouble();

                        Product importedProduct = new ImportedProduct(name, price, customsFee);
                        list.add(importedProduct);
                    }
                }
            }
        }
        System.out.println();
        for (Product product : list) {
            System.out.print(product);
        }
    
}