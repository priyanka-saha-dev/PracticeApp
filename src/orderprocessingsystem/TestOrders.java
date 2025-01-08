package orderprocessingsystem;

import orderprocessingsystem.model.Order;
import orderprocessingsystem.model.Status;
import orderprocessingsystem.processor.OrderProcessor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestOrders {

    public static void main(String[] args) {
        List<Order> allOrders = Stream.of(
                new Order(1, 500.00, Status.NEW, LocalDate.of(2020, 12, 31)),
                new Order(2, 100.00, Status.COMPLETED, LocalDate.of(2024, 5, 12)),
                new Order(3, 1454.00, Status.CANCELLED, LocalDate.of(2021, 6, 6)),
                new Order(4, 1233.99, Status.PROCESSING, LocalDate.of(2022, 10, 10)),
                new Order(5, 45.12, Status.COMPLETED, LocalDate.of(2023, 2, 19)),
                new Order(5, 45.12, Status.PROCESSING, LocalDate.of(2024, 1, 25))
        ).collect(Collectors.toList());

        List<Order> orders = OrderProcessor.filterOrderByStatus(allOrders, "PROCESSING");
        System.out.println("PROCESSING orders : " + orders);

        Double totalAmount = OrderProcessor.calculateTotalAmountForCompletedOrders(allOrders);
        System.out.println("COMPLETED orders - total Amount : " + totalAmount);

        List<Order> sortedOrders = OrderProcessor.sortOrderByDescendingOrder(allOrders);
        System.out.println("Descending Orders : " + sortedOrders);

        Optional<Order> oldestOrder = OrderProcessor.findOldestOrder(allOrders);
        System.out.println("Oldest Orders : " + oldestOrder);

    }
}
