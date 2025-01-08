package orderprocessingsystem.model;

import java.time.LocalDate;

public class Order {

    private Integer id;
    private Double amount;
    private Status status;
    private LocalDate date;

    public Order(Integer id, Double amount, Status status, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amount=" + amount +
                ", status=" + status +
                ", date=" + date +
                '}';
    }
}
