package entities;
import enums.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;
    private Product product;

    List<OrderItem> items = new ArrayList<>();

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter dateTimeFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Order() {
    }

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }
    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        double total = 0;
        for (OrderItem orders : items) {
            total += orders.subTotal();
        }
        return total;
    }

    public String toString() {
        StringBuilder summary = new StringBuilder();
        summary.append("ORDER SUMMARY: ").append("\n");
        summary.append("Order moment: ");
        summary.append(moment.format(dateTimeFmt)).append("\n");
        summary.append("Order status: ");
        summary.append(status).append("\n");
        summary.append("Client name: ");
        summary.append(client.getName()).append(" (");
        summary.append(client.getBirthDate().format(fmt)).append(") ");
        summary.append(client.getEmail()).append("\n");
        summary.append("Order items: ").append("\n");
        for (OrderItem p : items) {
            summary.append(p.getProduct().getName()).append(" $").append(p.getPrice()).append(", Quantity: ")
                    .append(p.getQuantity()).append(", Subtotal: ").append(p.subTotal()).append("\n");
        }
        summary.append("Total price: $").append(total());
        return summary.toString();
    }

}
