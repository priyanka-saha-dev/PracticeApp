package orderprocessingsystem.processor;

import orderprocessingsystem.model.Order;
import orderprocessingsystem.model.Status;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class OrderProcessor {

//    Filter Orders by Status: Write a method that filters orders based on their status and returns a list of filtered orders.
    public static List<Order> filterOrderByStatus(List<Order> orders, String status) {
        List<Order> ordersFilteredByStatus = Collections.emptyList();

        Optional<Status> orderStatus = Optional.ofNullable(status).map(Status::mapStatus);
        if(orderStatus.isPresent()) {
            ordersFilteredByStatus = orders.stream().filter(order -> order.getStatus().equals(orderStatus.get()))
                    .toList();
        }
        return ordersFilteredByStatus;
    }

//    Calculate Total Amount: Write a method that calculates the total amount for orders with the status "COMPLETED".
    public static Double calculateTotalAmountForCompletedOrders(List<Order> orders) {
        List<Order> completedOrders = filterOrderByStatus(orders, "COMPLETED");
        return completedOrders.stream().map(Order::getAmount).reduce(Double::sum).orElse(0.0);
    }

//    Find Oldest Order: Write a method that finds the oldest order from the list.
    public static Optional<Order> findOldestOrder(List<Order> orders) {
        return orders.stream().min(Comparator.comparing(Order::getDate));
    }

//    Sort Orders by Date: Write a method that sorts the orders by their date in descending order.
    public static List<Order> sortOrderByDescendingOrder(List<Order> orders) {
        if(orders != null && !orders.isEmpty()) {
            orders.sort(Comparator.comparing(Order::getDate).reversed());
            return orders;
        }
        return Collections.emptyList();
    }
}
