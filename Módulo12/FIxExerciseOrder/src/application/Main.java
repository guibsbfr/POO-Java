package application;

import entities.*;
import enums.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String bd = sc.nextLine();
        LocalDate birthDate = LocalDate.parse(bd, fmt);

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        LocalDateTime moment = LocalDateTime.now();
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());
        System.out.print("How many items to this order? ");
        int itemsQuantity = sc.nextInt();

        Order order = new Order(moment, status, client);

        for (int i = 0; i < itemsQuantity; i++) {
            System.out.println("Enter #" + (i + 1) + " item data: ");
            System.out.print("Product name: ");
            sc.nextLine();
            name = sc.nextLine();
            System.out.print("Product price: ");
            Double price = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();

            Product product = new Product(name, price);
            OrderItem item = new OrderItem(quantity, price, product);
            order.addItem(item);
        }

        System.out.println();
        System.out.println(order);
    }
}